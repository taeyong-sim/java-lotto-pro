package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoRank {
    LOSE(0, 0),
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000);

    private final int matchCount;
    private final int prize;

    LottoRank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    private static final Map<Integer, LottoRank> LOTTO_RANK_MAP =
        Collections.unmodifiableMap(Stream.of(values())
            .collect(Collectors.toMap(LottoRank::getMatchCount, Function.identity())));

    public static LottoRank findMatch(int matchCount) {
        return Optional.ofNullable(LOTTO_RANK_MAP.get(matchCount)).orElse(LOSE);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }
}
