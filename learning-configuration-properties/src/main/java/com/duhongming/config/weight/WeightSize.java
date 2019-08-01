package com.duhongming.config.weight;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author duhongming
 * @Email 935720334@qq.com
 * @Date 2019-08-01 21:17
 */
@Setter
@Getter
public class WeightSize implements Comparable<WeightSize>{

    private static final Pattern PATTERN = Pattern.compile("^([+\\-]?\\d+)([a-zA-Z]{0,2})$");

    private static long G_PER_KG = 1000L;
    private static long G_PER_T;

    /**
     * 默认为g
     */
    private final long weights;

    public WeightSize(long weights) {
        this.weights = weights;
    }

    public static WeightSize ofWeights(long weights) {
        return new WeightSize(weights);
    }

    public static WeightSize ofG(long g) {
        return new WeightSize(Math.multiplyExact(g, 1L));
    }

    public static WeightSize ofKG(long kg) {
        return new WeightSize(Math.multiplyExact(kg, G_PER_KG));
    }

    public static WeightSize ofT(long t) {
        return new WeightSize(Math.multiplyExact(t, G_PER_T));
    }

    public static WeightSize of(long amount, WeightUtil unit) {
        Assert.notNull(unit, "Unit must not be null");
        return new WeightSize(Math.multiplyExact(amount, unit.size().toG()));
    }

    public static WeightSize parse(CharSequence text) {
        return parse(text, (WeightUtil)null);
    }

    public static WeightSize parse(CharSequence text, @Nullable WeightUtil defaultUnit) {
        Assert.notNull(text, "Text must not be null");

        try {
            Matcher matcher = PATTERN.matcher(text);
            Assert.state(matcher.matches(), "Does not match data size pattern");
            WeightUtil unit = determineDataUnit(matcher.group(2), defaultUnit);
            long amount = Long.parseLong(matcher.group(1));
            return of(amount, unit);
        } catch (Exception var6) {
            throw new IllegalArgumentException("'" + text + "' is not a valid data size", var6);
        }
    }

    private static WeightUtil determineDataUnit(String suffix, @Nullable WeightUtil defaultUnit) {
        WeightUtil defaultUnitToUse = defaultUnit != null ? defaultUnit : WeightUtil.G;
        return StringUtils.hasLength(suffix) ? WeightUtil.fromSuffix(suffix) : defaultUnitToUse;
    }

    public long toG() {
        return this.weights;
    }

    @Override
    public String toString() {
        return String.format("%dg", this.weights);
    }

    @Override
    public int compareTo(WeightSize other) {
        return Long.compare(this.weights, other.weights);
    }

    static{
        G_PER_T = G_PER_KG * 1000L;
    }

}
