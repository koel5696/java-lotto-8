package lotto.domain;


import java.util.Optional;

public class WinLotto {
    private final Lotto winLotto;
    private final BonusNumber bonusNumber;

    public WinLotto(Lotto lotto, BonusNumber bonusNumber) {
        duplicateValidate(lotto, bonusNumber);
        winLotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void duplicateValidate(Lotto lotto, BonusNumber bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 기본 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public Optional<Rank> judgeWin(Lotto lotto) {
        int matchCount = lotto.countMatches(winLotto);
        boolean checkBonus = false;
        if (matchCount == 5) {
            checkBonus = secondJudgeWin(lotto);
        }
        return Rank.determineWinAmount(matchCount, checkBonus);

    }

    private boolean secondJudgeWin(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }
}
