package com.example.khxcx.pojo;

import java.util.ArrayList;
import java.util.List;

public class ShenQingTiXianExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShenQingTiXianExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBlankSpaceOneIsNull() {
            addCriterion("blank_space_one is null");
            return (Criteria) this;
        }

        public Criteria andBlankSpaceOneIsNotNull() {
            addCriterion("blank_space_one is not null");
            return (Criteria) this;
        }

        public Criteria andBlankSpaceOneEqualTo(String value) {
            addCriterion("blank_space_one =", value, "blankSpaceOne");
            return (Criteria) this;
        }

        public Criteria andBlankSpaceOneNotEqualTo(String value) {
            addCriterion("blank_space_one <>", value, "blankSpaceOne");
            return (Criteria) this;
        }

        public Criteria andBlankSpaceOneGreaterThan(String value) {
            addCriterion("blank_space_one >", value, "blankSpaceOne");
            return (Criteria) this;
        }

        public Criteria andBlankSpaceOneGreaterThanOrEqualTo(String value) {
            addCriterion("blank_space_one >=", value, "blankSpaceOne");
            return (Criteria) this;
        }

        public Criteria andBlankSpaceOneLessThan(String value) {
            addCriterion("blank_space_one <", value, "blankSpaceOne");
            return (Criteria) this;
        }

        public Criteria andBlankSpaceOneLessThanOrEqualTo(String value) {
            addCriterion("blank_space_one <=", value, "blankSpaceOne");
            return (Criteria) this;
        }

        public Criteria andBlankSpaceOneLike(String value) {
            addCriterion("blank_space_one like", value, "blankSpaceOne");
            return (Criteria) this;
        }

        public Criteria andBlankSpaceOneNotLike(String value) {
            addCriterion("blank_space_one not like", value, "blankSpaceOne");
            return (Criteria) this;
        }

        public Criteria andBlankSpaceOneIn(List<String> values) {
            addCriterion("blank_space_one in", values, "blankSpaceOne");
            return (Criteria) this;
        }

        public Criteria andBlankSpaceOneNotIn(List<String> values) {
            addCriterion("blank_space_one not in", values, "blankSpaceOne");
            return (Criteria) this;
        }

        public Criteria andBlankSpaceOneBetween(String value1, String value2) {
            addCriterion("blank_space_one between", value1, value2, "blankSpaceOne");
            return (Criteria) this;
        }

        public Criteria andBlankSpaceOneNotBetween(String value1, String value2) {
            addCriterion("blank_space_one not between", value1, value2, "blankSpaceOne");
            return (Criteria) this;
        }

        public Criteria andBlankSpaceThreeIsNull() {
            addCriterion("blank_space_three is null");
            return (Criteria) this;
        }

        public Criteria andBlankSpaceThreeIsNotNull() {
            addCriterion("blank_space_three is not null");
            return (Criteria) this;
        }

        public Criteria andBlankSpaceThreeEqualTo(String value) {
            addCriterion("blank_space_three =", value, "blankSpaceThree");
            return (Criteria) this;
        }

        public Criteria andBlankSpaceThreeNotEqualTo(String value) {
            addCriterion("blank_space_three <>", value, "blankSpaceThree");
            return (Criteria) this;
        }

        public Criteria andBlankSpaceThreeGreaterThan(String value) {
            addCriterion("blank_space_three >", value, "blankSpaceThree");
            return (Criteria) this;
        }

        public Criteria andBlankSpaceThreeGreaterThanOrEqualTo(String value) {
            addCriterion("blank_space_three >=", value, "blankSpaceThree");
            return (Criteria) this;
        }

        public Criteria andBlankSpaceThreeLessThan(String value) {
            addCriterion("blank_space_three <", value, "blankSpaceThree");
            return (Criteria) this;
        }

        public Criteria andBlankSpaceThreeLessThanOrEqualTo(String value) {
            addCriterion("blank_space_three <=", value, "blankSpaceThree");
            return (Criteria) this;
        }

        public Criteria andBlankSpaceThreeLike(String value) {
            addCriterion("blank_space_three like", value, "blankSpaceThree");
            return (Criteria) this;
        }

        public Criteria andBlankSpaceThreeNotLike(String value) {
            addCriterion("blank_space_three not like", value, "blankSpaceThree");
            return (Criteria) this;
        }

        public Criteria andBlankSpaceThreeIn(List<String> values) {
            addCriterion("blank_space_three in", values, "blankSpaceThree");
            return (Criteria) this;
        }

        public Criteria andBlankSpaceThreeNotIn(List<String> values) {
            addCriterion("blank_space_three not in", values, "blankSpaceThree");
            return (Criteria) this;
        }

        public Criteria andBlankSpaceThreeBetween(String value1, String value2) {
            addCriterion("blank_space_three between", value1, value2, "blankSpaceThree");
            return (Criteria) this;
        }

        public Criteria andBlankSpaceThreeNotBetween(String value1, String value2) {
            addCriterion("blank_space_three not between", value1, value2, "blankSpaceThree");
            return (Criteria) this;
        }

        public Criteria andBlankSpaceTwoIsNull() {
            addCriterion("blank_space_two is null");
            return (Criteria) this;
        }

        public Criteria andBlankSpaceTwoIsNotNull() {
            addCriterion("blank_space_two is not null");
            return (Criteria) this;
        }

        public Criteria andBlankSpaceTwoEqualTo(String value) {
            addCriterion("blank_space_two =", value, "blankSpaceTwo");
            return (Criteria) this;
        }

        public Criteria andBlankSpaceTwoNotEqualTo(String value) {
            addCriterion("blank_space_two <>", value, "blankSpaceTwo");
            return (Criteria) this;
        }

        public Criteria andBlankSpaceTwoGreaterThan(String value) {
            addCriterion("blank_space_two >", value, "blankSpaceTwo");
            return (Criteria) this;
        }

        public Criteria andBlankSpaceTwoGreaterThanOrEqualTo(String value) {
            addCriterion("blank_space_two >=", value, "blankSpaceTwo");
            return (Criteria) this;
        }

        public Criteria andBlankSpaceTwoLessThan(String value) {
            addCriterion("blank_space_two <", value, "blankSpaceTwo");
            return (Criteria) this;
        }

        public Criteria andBlankSpaceTwoLessThanOrEqualTo(String value) {
            addCriterion("blank_space_two <=", value, "blankSpaceTwo");
            return (Criteria) this;
        }

        public Criteria andBlankSpaceTwoLike(String value) {
            addCriterion("blank_space_two like", value, "blankSpaceTwo");
            return (Criteria) this;
        }

        public Criteria andBlankSpaceTwoNotLike(String value) {
            addCriterion("blank_space_two not like", value, "blankSpaceTwo");
            return (Criteria) this;
        }

        public Criteria andBlankSpaceTwoIn(List<String> values) {
            addCriterion("blank_space_two in", values, "blankSpaceTwo");
            return (Criteria) this;
        }

        public Criteria andBlankSpaceTwoNotIn(List<String> values) {
            addCriterion("blank_space_two not in", values, "blankSpaceTwo");
            return (Criteria) this;
        }

        public Criteria andBlankSpaceTwoBetween(String value1, String value2) {
            addCriterion("blank_space_two between", value1, value2, "blankSpaceTwo");
            return (Criteria) this;
        }

        public Criteria andBlankSpaceTwoNotBetween(String value1, String value2) {
            addCriterion("blank_space_two not between", value1, value2, "blankSpaceTwo");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNull() {
            addCriterion("money is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("money is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(Double value) {
            addCriterion("money =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(Double value) {
            addCriterion("money <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(Double value) {
            addCriterion("money >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("money >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(Double value) {
            addCriterion("money <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(Double value) {
            addCriterion("money <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<Double> values) {
            addCriterion("money in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<Double> values) {
            addCriterion("money not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(Double value1, Double value2) {
            addCriterion("money between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(Double value1, Double value2) {
            addCriterion("money not between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNull() {
            addCriterion("open_id is null");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNotNull() {
            addCriterion("open_id is not null");
            return (Criteria) this;
        }

        public Criteria andOpenIdEqualTo(String value) {
            addCriterion("open_id =", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotEqualTo(String value) {
            addCriterion("open_id <>", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThan(String value) {
            addCriterion("open_id >", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("open_id >=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThan(String value) {
            addCriterion("open_id <", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThanOrEqualTo(String value) {
            addCriterion("open_id <=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLike(String value) {
            addCriterion("open_id like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotLike(String value) {
            addCriterion("open_id not like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdIn(List<String> values) {
            addCriterion("open_id in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotIn(List<String> values) {
            addCriterion("open_id not in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdBetween(String value1, String value2) {
            addCriterion("open_id between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotBetween(String value1, String value2) {
            addCriterion("open_id not between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIsNull() {
            addCriterion("phone_number is null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIsNotNull() {
            addCriterion("phone_number is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberEqualTo(String value) {
            addCriterion("phone_number =", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotEqualTo(String value) {
            addCriterion("phone_number <>", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberGreaterThan(String value) {
            addCriterion("phone_number >", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberGreaterThanOrEqualTo(String value) {
            addCriterion("phone_number >=", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLessThan(String value) {
            addCriterion("phone_number <", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLessThanOrEqualTo(String value) {
            addCriterion("phone_number <=", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLike(String value) {
            addCriterion("phone_number like", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotLike(String value) {
            addCriterion("phone_number not like", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIn(List<String> values) {
            addCriterion("phone_number in", values, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotIn(List<String> values) {
            addCriterion("phone_number not in", values, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberBetween(String value1, String value2) {
            addCriterion("phone_number between", value1, value2, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotBetween(String value1, String value2) {
            addCriterion("phone_number not between", value1, value2, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}