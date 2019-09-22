package com.duhongming.config.weight;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * @Author duhongming
 * @Email 935720334@qq.com
 * @Date 2019-08-01 21:45
 */
@AllArgsConstructor
@Getter
public enum WeightUtil {
    G("k",WeightSize.ofG(1L)),
    KG("kg",WeightSize.ofKG(1L)),
    T("t",WeightSize.ofT(1L));

    private final String suffix;
    private final WeightSize size;

    WeightSize size() {
        return this.size;
    }

    public static WeightUtil fromSuffix(String suffix) {
        WeightUtil[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            WeightUtil candidate = var1[var3];
            if (Objects.equals(candidate.suffix, suffix)) {
                return candidate;
            }
        }

        throw new IllegalArgumentException("Unknown unit '" + suffix + "'");
    }
}
