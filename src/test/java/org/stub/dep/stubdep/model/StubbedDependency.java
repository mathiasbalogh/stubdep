package org.stub.dep.stubdep.model;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.*;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;
import java.util.UUID;

public class StubbedDependency {

    public String string;

    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "must be alphanumeric")
    protected String regex;

    @NotBlank
    private String notBlank;

    @NotEmpty
    public String notEmpty;

    @Email
    public String email;

    @Size(min = 4, max = 10)
    public String sized;

    public UUID uuid;

    @Min(value = 20)
    public Integer min;

    @Max(value = 200)
    public int max;

    @Min(value = 20)
    @Max(value = 200)
    public Integer minMax;

    @Positive
    public int positive;

    @Negative
    public Integer negative;

    @NegativeOrZero
    public int negativeOrZero;

    @PositiveOrZero
    public Integer positiveOrZero;

    @Min(value = 20)
    public Long minLong;

    @Max(value = 200)
    public long maxLong;

    @Min(value = 20)
    @Max(value = 200)
    public Long minMaxLong;

    @Positive
    public long positiveLong;

    @Negative
    public Long negativeLong;

    @NegativeOrZero
    public long negativeOrZeroLong;

    @PositiveOrZero
    public Long positiveOrZeroLong;

    @Min(value = 20)
    public Short minShort;

    @Max(value = 200)
    public short maxShort;

    @Min(value = 20)
    @Max(value = 200)
    public Short minMaxShort;

    @Positive
    public short positiveShort;

    @Negative
    public Short negativeShort;

    @NegativeOrZero
    public short negativeOrZeroShort;

    @PositiveOrZero
    public Short positiveOrZeroShort;

    @Min(value = 20)
    public Double minDouble;

    @Max(value = 200)
    public double maxDouble;

    @Min(value = 20)
    @Max(value = 200)
    public Double minMaxDouble;

    @Positive
    public double positiveDouble;

    @Negative
    public Double negativeDouble;

    @NegativeOrZero
    public double negativeOrZeroDouble;

    @PositiveOrZero
    public Double positiveOrZeroDouble;

    @Min(value = 20)
    public Float minFloat;

    @Max(value = 200)
    public float maxFloat;

    @Min(value = 20)
    @Max(value = 200)
    public Float minMaxFloat;

    @Positive
    public float positiveFloat;

    @Negative
    public Float negativeFloat;

    @NegativeOrZero
    public float negativeOrZeroFloat;

    @PositiveOrZero
    public Float positiveOrZeroFloat;

    public Boolean bool;

    public boolean bool2;

    @Future
    public Instant future;

    @FutureOrPresent
    public Instant futureOrPresent;

    @Past
    public Instant past;

    @PastOrPresent
    public Instant pastOrPresent;

    public Instant instant;

    public Date date;

    @Future
    public Date futureDate;

    @Past
    public Date pastDate;

    @FutureOrPresent
    public Date futureOrPresentDate;

    @PastOrPresent
    public Date pastOrPresentDate;

    public List<Integer> list;

    public List<Nested> listWithCustomPojo;

    public Map<String, Nested> map;

    public List<Map<String,Nested>> listWithMap;

    @ManyToOne
    public List<Nested> manyToOne;

    @ManyToMany
    public List<Nested> manyToMany;

    @OneToOne
    public List<Nested> oneToOne;

    @OneToMany
    public List<Nested> oneToMany;

    public Set<String> set;

    public Set<Nested> setWithCustomPojo;

    public List<Nested> getManyToOne() {
        return manyToOne;
    }

    public void setManyToOne(List<Nested> manyToOne) {
        this.manyToOne = manyToOne;
    }

    public List<Nested> getManyToMany() {
        return manyToMany;
    }

    public void setManyToMany(List<Nested> manyToMany) {
        this.manyToMany = manyToMany;
    }

    public List<Nested> getOneToOne() {
        return oneToOne;
    }

    public void setOneToOne(List<Nested> oneToOne) {
        this.oneToOne = oneToOne;
    }

    public List<Nested> getOneToMany() {
        return oneToMany;
    }

    public void setOneToMany(List<Nested> oneToMany) {
        this.oneToMany = oneToMany;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public Set<Nested> getSetWithCustomPojo() {
        return setWithCustomPojo;
    }

    public void setSetWithCustomPojo(Set<Nested> setWithCustomPojo) {
        this.setWithCustomPojo = setWithCustomPojo;
    }

    public List<Map<String, Nested>> getListWithMap() {
        return listWithMap;
    }

    public void setListWithMap(List<Map<String, Nested>> listWithMap) {
        this.listWithMap = listWithMap;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public String getNotBlank() {
        return notBlank;
    }

    public void setNotBlank(String notBlank) {
        this.notBlank = notBlank;
    }

    public String getNotEmpty() {
        return notEmpty;
    }

    public void setNotEmpty(String notEmpty) {
        this.notEmpty = notEmpty;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSized() {
        return sized;
    }

    public void setSized(String sized) {
        this.sized = sized;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public Integer getMinMax() {
        return minMax;
    }

    public void setMinMax(Integer minMax) {
        this.minMax = minMax;
    }

    @Positive
    public int getPositive() {
        return positive;
    }

    public void setPositive(@Positive int positive) {
        this.positive = positive;
    }

    public @Negative Integer getNegative() {
        return negative;
    }

    public void setNegative(@Negative Integer negative) {
        this.negative = negative;
    }

    @NegativeOrZero
    public int getNegativeOrZero() {
        return negativeOrZero;
    }

    public void setNegativeOrZero(@NegativeOrZero int negativeOrZero) {
        this.negativeOrZero = negativeOrZero;
    }

    public @PositiveOrZero Integer getPositiveOrZero() {
        return positiveOrZero;
    }

    public void setPositiveOrZero(@PositiveOrZero Integer positiveOrZero) {
        this.positiveOrZero = positiveOrZero;
    }

    public Long getMinLong() {
        return minLong;
    }

    public void setMinLong(Long minLong) {
        this.minLong = minLong;
    }

    public long getMaxLong() {
        return maxLong;
    }

    public void setMaxLong(long maxLong) {
        this.maxLong = maxLong;
    }

    public Long getMinMaxLong() {
        return minMaxLong;
    }

    public void setMinMaxLong(Long minMaxLong) {
        this.minMaxLong = minMaxLong;
    }

    @Positive
    public long getPositiveLong() {
        return positiveLong;
    }

    public void setPositiveLong(@Positive long positiveLong) {
        this.positiveLong = positiveLong;
    }

    public @Negative Long getNegativeLong() {
        return negativeLong;
    }

    public void setNegativeLong(@Negative Long negativeLong) {
        this.negativeLong = negativeLong;
    }

    @NegativeOrZero
    public long getNegativeOrZeroLong() {
        return negativeOrZeroLong;
    }

    public void setNegativeOrZeroLong(@NegativeOrZero long negativeOrZeroLong) {
        this.negativeOrZeroLong = negativeOrZeroLong;
    }

    public @PositiveOrZero Long getPositiveOrZeroLong() {
        return positiveOrZeroLong;
    }

    public void setPositiveOrZeroLong(@PositiveOrZero Long positiveOrZeroLong) {
        this.positiveOrZeroLong = positiveOrZeroLong;
    }

    public Short getMinShort() {
        return minShort;
    }

    public void setMinShort(Short minShort) {
        this.minShort = minShort;
    }

    public short getMaxShort() {
        return maxShort;
    }

    public void setMaxShort(short maxShort) {
        this.maxShort = maxShort;
    }

    public Short getMinMaxShort() {
        return minMaxShort;
    }

    public void setMinMaxShort(Short minMaxShort) {
        this.minMaxShort = minMaxShort;
    }

    @Positive
    public short getPositiveShort() {
        return positiveShort;
    }

    public void setPositiveShort(@Positive short positiveShort) {
        this.positiveShort = positiveShort;
    }

    public @Negative Short getNegativeShort() {
        return negativeShort;
    }

    public void setNegativeShort(@Negative Short negativeShort) {
        this.negativeShort = negativeShort;
    }

    @NegativeOrZero
    public short getNegativeOrZeroShort() {
        return negativeOrZeroShort;
    }

    public void setNegativeOrZeroShort(@NegativeOrZero short negativeOrZeroShort) {
        this.negativeOrZeroShort = negativeOrZeroShort;
    }

    public @PositiveOrZero Short getPositiveOrZeroShort() {
        return positiveOrZeroShort;
    }

    public void setPositiveOrZeroShort(@PositiveOrZero Short positiveOrZeroShort) {
        this.positiveOrZeroShort = positiveOrZeroShort;
    }

    public Double getMinDouble() {
        return minDouble;
    }

    public void setMinDouble(Double minDouble) {
        this.minDouble = minDouble;
    }

    public double getMaxDouble() {
        return maxDouble;
    }

    public void setMaxDouble(double maxDouble) {
        this.maxDouble = maxDouble;
    }

    public Double getMinMaxDouble() {
        return minMaxDouble;
    }

    public void setMinMaxDouble(Double minMaxDouble) {
        this.minMaxDouble = minMaxDouble;
    }

    @Positive
    public double getPositiveDouble() {
        return positiveDouble;
    }

    public void setPositiveDouble(@Positive double positiveDouble) {
        this.positiveDouble = positiveDouble;
    }

    public @Negative Double getNegativeDouble() {
        return negativeDouble;
    }

    public void setNegativeDouble(@Negative Double negativeDouble) {
        this.negativeDouble = negativeDouble;
    }

    @NegativeOrZero
    public double getNegativeOrZeroDouble() {
        return negativeOrZeroDouble;
    }

    public void setNegativeOrZeroDouble(@NegativeOrZero double negativeOrZeroDouble) {
        this.negativeOrZeroDouble = negativeOrZeroDouble;
    }

    public @PositiveOrZero Double getPositiveOrZeroDouble() {
        return positiveOrZeroDouble;
    }

    public void setPositiveOrZeroDouble(@PositiveOrZero Double positiveOrZeroDouble) {
        this.positiveOrZeroDouble = positiveOrZeroDouble;
    }

    public Float getMinFloat() {
        return minFloat;
    }

    public void setMinFloat(Float minFloat) {
        this.minFloat = minFloat;
    }

    public float getMaxFloat() {
        return maxFloat;
    }

    public void setMaxFloat(float maxFloat) {
        this.maxFloat = maxFloat;
    }

    public Float getMinMaxFloat() {
        return minMaxFloat;
    }

    public void setMinMaxFloat(Float minMaxFloat) {
        this.minMaxFloat = minMaxFloat;
    }

    @Positive
    public float getPositiveFloat() {
        return positiveFloat;
    }

    public void setPositiveFloat(@Positive float positiveFloat) {
        this.positiveFloat = positiveFloat;
    }

    public @Negative Float getNegativeFloat() {
        return negativeFloat;
    }

    public void setNegativeFloat(@Negative Float negativeFloat) {
        this.negativeFloat = negativeFloat;
    }

    @NegativeOrZero
    public float getNegativeOrZeroFloat() {
        return negativeOrZeroFloat;
    }

    public void setNegativeOrZeroFloat(@NegativeOrZero float negativeOrZeroFloat) {
        this.negativeOrZeroFloat = negativeOrZeroFloat;
    }

    public @PositiveOrZero Float getPositiveOrZeroFloat() {
        return positiveOrZeroFloat;
    }

    public void setPositiveOrZeroFloat(@PositiveOrZero Float positiveOrZeroFloat) {
        this.positiveOrZeroFloat = positiveOrZeroFloat;
    }

    public Boolean getBool() {
        return bool;
    }

    public void setBool(Boolean bool) {
        this.bool = bool;
    }

    public boolean isBool2() {
        return bool2;
    }

    public void setBool2(boolean bool2) {
        this.bool2 = bool2;
    }

    public @Future Instant getFuture() {
        return future;
    }

    public void setFuture(@Future Instant future) {
        this.future = future;
    }

    public @Past Instant getPast() {
        return past;
    }

    public void setPast(@Past Instant past) {
        this.past = past;
    }

    public Instant getInstant() {
        return instant;
    }

    public void setInstant(Instant instant) {
        this.instant = instant;
    }

    public @FutureOrPresent Instant getFutureOrPresent() {
        return futureOrPresent;
    }

    public void setFutureOrPresent(@FutureOrPresent Instant futureOrPresent) {
        this.futureOrPresent = futureOrPresent;
    }

    public @PastOrPresent Instant getPastOrPresent() {
        return pastOrPresent;
    }

    public void setPastOrPresent(@PastOrPresent Instant pastOrPresent) {
        this.pastOrPresent = pastOrPresent;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public @Future Date getFutureDate() {
        return futureDate;
    }

    public void setFutureDate(@Future Date futureDate) {
        this.futureDate = futureDate;
    }

    public @Past Date getPastDate() {
        return pastDate;
    }

    public void setPastDate(@Past Date pastDate) {
        this.pastDate = pastDate;
    }

    public @FutureOrPresent Date getFutureOrPresentDate() {
        return futureOrPresentDate;
    }

    public void setFutureOrPresentDate(@FutureOrPresent Date futureOrPresentDate) {
        this.futureOrPresentDate = futureOrPresentDate;
    }

    public @PastOrPresent Date getPastOrPresentDate() {
        return pastOrPresentDate;
    }

    public void setPastOrPresentDate(@PastOrPresent Date pastOrPresentDate) {
        this.pastOrPresentDate = pastOrPresentDate;
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public List<Nested> getListWithCustomPojo() {
        return listWithCustomPojo;
    }

    public void setListWithCustomPojo(List<Nested> listWithCustomPojo) {
        this.listWithCustomPojo = listWithCustomPojo;
    }

    public Map<String, Nested> getMap() {
        return map;
    }

    public void setMap(Map<String, Nested> map) {
        this.map = map;
    }

    public static class Nested {
        private String string;

        protected Integer integer;

        public boolean bool;

        public String getString() {
            return string;
        }

        public void setString(String string) {
            this.string = string;
        }

        public Integer getInteger() {
            return integer;
        }

        public void setInteger(Integer integer) {
            this.integer = integer;
        }

        public boolean isBool() {
            return bool;
        }

        public void setBool(boolean bool) {
            this.bool = bool;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Nested.class.getSimpleName() + "[", "]")
                    .add("string='" + string + "'")
                    .add("integer=" + integer)
                    .add("bool=" + bool)
                    .toString();
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StubbedDependency.class.getSimpleName() + "[", "]")
                .add("string='" + string + "'")
                .add("regex='" + regex + "'")
                .add("notBlank='" + notBlank + "'")
                .add("notEmpty='" + notEmpty + "'")
                .add("email='" + email + "'")
                .add("sized='" + sized + "'")
                .add("uuid=" + uuid)
                .add("min=" + min)
                .add("max=" + max)
                .add("minMax=" + minMax)
                .add("positive=" + positive)
                .add("negative=" + negative)
                .add("negativeOrZero=" + negativeOrZero)
                .add("positiveOrZero=" + positiveOrZero)
                .add("minLong=" + minLong)
                .add("maxLong=" + maxLong)
                .add("minMaxLong=" + minMaxLong)
                .add("positiveLong=" + positiveLong)
                .add("negativeLong=" + negativeLong)
                .add("negativeOrZeroLong=" + negativeOrZeroLong)
                .add("positiveOrZeroLong=" + positiveOrZeroLong)
                .add("minShort=" + minShort)
                .add("maxShort=" + maxShort)
                .add("minMaxShort=" + minMaxShort)
                .add("positiveShort=" + positiveShort)
                .add("negativeShort=" + negativeShort)
                .add("negativeOrZeroShort=" + negativeOrZeroShort)
                .add("positiveOrZeroShort=" + positiveOrZeroShort)
                .add("minDouble=" + minDouble)
                .add("maxDouble=" + maxDouble)
                .add("minMaxDouble=" + minMaxDouble)
                .add("positiveDouble=" + positiveDouble)
                .add("negativeDouble=" + negativeDouble)
                .add("negativeOrZeroDouble=" + negativeOrZeroDouble)
                .add("positiveOrZeroDouble=" + positiveOrZeroDouble)
                .add("minFloat=" + minFloat)
                .add("maxFloat=" + maxFloat)
                .add("minMaxFloat=" + minMaxFloat)
                .add("positiveFloat=" + positiveFloat)
                .add("negativeFloat=" + negativeFloat)
                .add("negativeOrZeroFloat=" + negativeOrZeroFloat)
                .add("positiveOrZeroFloat=" + positiveOrZeroFloat)
                .add("bool=" + bool)
                .add("bool2=" + bool2)
                .add("future=" + future)
                .add("futureOrPresent=" + futureOrPresent)
                .add("past=" + past)
                .add("pastOrPresent=" + pastOrPresent)
                .add("instant=" + instant)
                .add("date=" + date)
                .add("futureDate=" + futureDate)
                .add("pastDate=" + pastDate)
                .add("futureOrPresentDate=" + futureOrPresentDate)
                .add("pastOrPresentDate=" + pastOrPresentDate)
                .add("list=" + list)
                .add("listWithCustomPojo=" + listWithCustomPojo)
                .add("map=" + map)
                .add("listWithMap=" + listWithMap)
                .add("manyToOne=" + manyToOne)
                .add("manyToMany=" + manyToMany)
                .add("oneToOne=" + oneToOne)
                .add("oneToMany=" + oneToMany)
                .add("set="+set)
                .add("setWithCustomPojo="+setWithCustomPojo)
                .toString();
    }
}
