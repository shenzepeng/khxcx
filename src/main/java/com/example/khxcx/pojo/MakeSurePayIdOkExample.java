package com.example.khxcx.pojo;

import java.util.ArrayList;
import java.util.List;

public class MakeSurePayIdOkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MakeSurePayIdOkExample() {
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

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(String value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(String value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(String value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(String value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLike(String value) {
            addCriterion("create_time like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            addCriterion("create_time not like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<String> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<String> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(String value1, String value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andOpendIdIsNull() {
            addCriterion("opend_id is null");
            return (Criteria) this;
        }

        public Criteria andOpendIdIsNotNull() {
            addCriterion("opend_id is not null");
            return (Criteria) this;
        }

        public Criteria andOpendIdEqualTo(String value) {
            addCriterion("opend_id =", value, "opendId");
            return (Criteria) this;
        }

        public Criteria andOpendIdNotEqualTo(String value) {
            addCriterion("opend_id <>", value, "opendId");
            return (Criteria) this;
        }

        public Criteria andOpendIdGreaterThan(String value) {
            addCriterion("opend_id >", value, "opendId");
            return (Criteria) this;
        }

        public Criteria andOpendIdGreaterThanOrEqualTo(String value) {
            addCriterion("opend_id >=", value, "opendId");
            return (Criteria) this;
        }

        public Criteria andOpendIdLessThan(String value) {
            addCriterion("opend_id <", value, "opendId");
            return (Criteria) this;
        }

        public Criteria andOpendIdLessThanOrEqualTo(String value) {
            addCriterion("opend_id <=", value, "opendId");
            return (Criteria) this;
        }

        public Criteria andOpendIdLike(String value) {
            addCriterion("opend_id like", value, "opendId");
            return (Criteria) this;
        }

        public Criteria andOpendIdNotLike(String value) {
            addCriterion("opend_id not like", value, "opendId");
            return (Criteria) this;
        }

        public Criteria andOpendIdIn(List<String> values) {
            addCriterion("opend_id in", values, "opendId");
            return (Criteria) this;
        }

        public Criteria andOpendIdNotIn(List<String> values) {
            addCriterion("opend_id not in", values, "opendId");
            return (Criteria) this;
        }

        public Criteria andOpendIdBetween(String value1, String value2) {
            addCriterion("opend_id between", value1, value2, "opendId");
            return (Criteria) this;
        }

        public Criteria andOpendIdNotBetween(String value1, String value2) {
            addCriterion("opend_id not between", value1, value2, "opendId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
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

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
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