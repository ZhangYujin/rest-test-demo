package com.focsim.demo.utils;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据对象转换，从一个对象转成另外一个对象。
 *
 * @author jinlei
 * @createdOn 2017/4/20
 */
public final class DtoUtils {

    private static final ModelMapper INSTANCE = new ModelMapper();
    private static final ModelMapper INSTANCE_STRICT = new ModelMapper();

    static {
        //对象复制的时候不复制空值
        INSTANCE.getConfiguration().setPropertyCondition(Conditions.isNotNull());

        //严格模式
        INSTANCE_STRICT.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        INSTANCE_STRICT.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    private DtoUtils() {
        throw new InstantiationError("Must not instantiate this class");
    }

    public static <S, T> T map(S source, Class<T> targetClass, boolean isStrict) {
        if (isStrict) {
            return INSTANCE_STRICT.map(source, targetClass);
        } else {
            return INSTANCE.map(source, targetClass);
        }
    }

    public static <S, T> void mapTo(S source, T dist, boolean isStrict) {
        if (isStrict) {
            INSTANCE_STRICT.map(source, dist);
        } else {
            INSTANCE.map(source, dist);
        }
    }

    public static <S, T> List<T> mapList(List<S> source, Class<T> targetClass, boolean isStrict) {

        List<T> list = new ArrayList<>(source.size());

        if (isStrict) {
            for (int i = 0; i < source.size(); i++) {
                T target = INSTANCE_STRICT.map(source.get(i), targetClass);
                list.add(target);
            }
        } else {
            for (int i = 0; i < source.size(); i++) {
                T target = INSTANCE.map(source.get(i), targetClass);
                list.add(target);
            }
        }

        return list;
    }

}

