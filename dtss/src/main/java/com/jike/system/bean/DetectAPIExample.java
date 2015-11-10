package com.jike.system.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DetectAPIExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public DetectAPIExample() {
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

    public void setPage(Page page) {
        this.page=page;
    }

    public Page getPage() {
        return page;
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

        public Criteria andTaskIdIsNull() {
            addCriterion("TASK_ID is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("TASK_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(String value) {
            addCriterion("TASK_ID =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(String value) {
            addCriterion("TASK_ID <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(String value) {
            addCriterion("TASK_ID >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(String value) {
            addCriterion("TASK_ID >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(String value) {
            addCriterion("TASK_ID <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(String value) {
            addCriterion("TASK_ID <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLike(String value) {
            addCriterion("TASK_ID like", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotLike(String value) {
            addCriterion("TASK_ID not like", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<String> values) {
            addCriterion("TASK_ID in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<String> values) {
            addCriterion("TASK_ID not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(String value1, String value2) {
            addCriterion("TASK_ID between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(String value1, String value2) {
            addCriterion("TASK_ID not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskRunTimeIsNull() {
            addCriterion("TASK_RUN_TIME is null");
            return (Criteria) this;
        }

        public Criteria andTaskRunTimeIsNotNull() {
            addCriterion("TASK_RUN_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andTaskRunTimeEqualTo(Date value) {
            addCriterion("TASK_RUN_TIME =", value, "taskRunTime");
            return (Criteria) this;
        }

        public Criteria andTaskRunTimeNotEqualTo(Date value) {
            addCriterion("TASK_RUN_TIME <>", value, "taskRunTime");
            return (Criteria) this;
        }

        public Criteria andTaskRunTimeGreaterThan(Date value) {
            addCriterion("TASK_RUN_TIME >", value, "taskRunTime");
            return (Criteria) this;
        }

        public Criteria andTaskRunTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("TASK_RUN_TIME >=", value, "taskRunTime");
            return (Criteria) this;
        }

        public Criteria andTaskRunTimeLessThan(Date value) {
            addCriterion("TASK_RUN_TIME <", value, "taskRunTime");
            return (Criteria) this;
        }

        public Criteria andTaskRunTimeLessThanOrEqualTo(Date value) {
            addCriterion("TASK_RUN_TIME <=", value, "taskRunTime");
            return (Criteria) this;
        }

        public Criteria andTaskRunTimeIn(List<Date> values) {
            addCriterion("TASK_RUN_TIME in", values, "taskRunTime");
            return (Criteria) this;
        }

        public Criteria andTaskRunTimeNotIn(List<Date> values) {
            addCriterion("TASK_RUN_TIME not in", values, "taskRunTime");
            return (Criteria) this;
        }

        public Criteria andTaskRunTimeBetween(Date value1, Date value2) {
            addCriterion("TASK_RUN_TIME between", value1, value2, "taskRunTime");
            return (Criteria) this;
        }

        public Criteria andTaskRunTimeNotBetween(Date value1, Date value2) {
            addCriterion("TASK_RUN_TIME not between", value1, value2, "taskRunTime");
            return (Criteria) this;
        }

        public Criteria andDepartCodeIsNull() {
            addCriterion("DEPART_CODE is null");
            return (Criteria) this;
        }

        public Criteria andDepartCodeIsNotNull() {
            addCriterion("DEPART_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andDepartCodeEqualTo(String value) {
            addCriterion("DEPART_CODE =", value, "departCode");
            return (Criteria) this;
        }

        public Criteria andDepartCodeNotEqualTo(String value) {
            addCriterion("DEPART_CODE <>", value, "departCode");
            return (Criteria) this;
        }

        public Criteria andDepartCodeGreaterThan(String value) {
            addCriterion("DEPART_CODE >", value, "departCode");
            return (Criteria) this;
        }

        public Criteria andDepartCodeGreaterThanOrEqualTo(String value) {
            addCriterion("DEPART_CODE >=", value, "departCode");
            return (Criteria) this;
        }

        public Criteria andDepartCodeLessThan(String value) {
            addCriterion("DEPART_CODE <", value, "departCode");
            return (Criteria) this;
        }

        public Criteria andDepartCodeLessThanOrEqualTo(String value) {
            addCriterion("DEPART_CODE <=", value, "departCode");
            return (Criteria) this;
        }

        public Criteria andDepartCodeLike(String value) {
            addCriterion("DEPART_CODE like", value, "departCode");
            return (Criteria) this;
        }

        public Criteria andDepartCodeNotLike(String value) {
            addCriterion("DEPART_CODE not like", value, "departCode");
            return (Criteria) this;
        }

        public Criteria andDepartCodeIn(List<String> values) {
            addCriterion("DEPART_CODE in", values, "departCode");
            return (Criteria) this;
        }

        public Criteria andDepartCodeNotIn(List<String> values) {
            addCriterion("DEPART_CODE not in", values, "departCode");
            return (Criteria) this;
        }

        public Criteria andDepartCodeBetween(String value1, String value2) {
            addCriterion("DEPART_CODE between", value1, value2, "departCode");
            return (Criteria) this;
        }

        public Criteria andDepartCodeNotBetween(String value1, String value2) {
            addCriterion("DEPART_CODE not between", value1, value2, "departCode");
            return (Criteria) this;
        }

        public Criteria andArriveCodeIsNull() {
            addCriterion("ARRIVE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andArriveCodeIsNotNull() {
            addCriterion("ARRIVE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andArriveCodeEqualTo(String value) {
            addCriterion("ARRIVE_CODE =", value, "arriveCode");
            return (Criteria) this;
        }

        public Criteria andArriveCodeNotEqualTo(String value) {
            addCriterion("ARRIVE_CODE <>", value, "arriveCode");
            return (Criteria) this;
        }

        public Criteria andArriveCodeGreaterThan(String value) {
            addCriterion("ARRIVE_CODE >", value, "arriveCode");
            return (Criteria) this;
        }

        public Criteria andArriveCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ARRIVE_CODE >=", value, "arriveCode");
            return (Criteria) this;
        }

        public Criteria andArriveCodeLessThan(String value) {
            addCriterion("ARRIVE_CODE <", value, "arriveCode");
            return (Criteria) this;
        }

        public Criteria andArriveCodeLessThanOrEqualTo(String value) {
            addCriterion("ARRIVE_CODE <=", value, "arriveCode");
            return (Criteria) this;
        }

        public Criteria andArriveCodeLike(String value) {
            addCriterion("ARRIVE_CODE like", value, "arriveCode");
            return (Criteria) this;
        }

        public Criteria andArriveCodeNotLike(String value) {
            addCriterion("ARRIVE_CODE not like", value, "arriveCode");
            return (Criteria) this;
        }

        public Criteria andArriveCodeIn(List<String> values) {
            addCriterion("ARRIVE_CODE in", values, "arriveCode");
            return (Criteria) this;
        }

        public Criteria andArriveCodeNotIn(List<String> values) {
            addCriterion("ARRIVE_CODE not in", values, "arriveCode");
            return (Criteria) this;
        }

        public Criteria andArriveCodeBetween(String value1, String value2) {
            addCriterion("ARRIVE_CODE between", value1, value2, "arriveCode");
            return (Criteria) this;
        }

        public Criteria andArriveCodeNotBetween(String value1, String value2) {
            addCriterion("ARRIVE_CODE not between", value1, value2, "arriveCode");
            return (Criteria) this;
        }

        public Criteria andDepartDateIsNull() {
            addCriterion("DEPART_DATE is null");
            return (Criteria) this;
        }

        public Criteria andDepartDateIsNotNull() {
            addCriterion("DEPART_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andDepartDateEqualTo(Date value) {
            addCriterion("DEPART_DATE =", value, "departDate");
            return (Criteria) this;
        }

        public Criteria andDepartDateNotEqualTo(Date value) {
            addCriterion("DEPART_DATE <>", value, "departDate");
            return (Criteria) this;
        }

        public Criteria andDepartDateGreaterThan(Date value) {
            addCriterion("DEPART_DATE >", value, "departDate");
            return (Criteria) this;
        }

        public Criteria andDepartDateGreaterThanOrEqualTo(Date value) {
            addCriterion("DEPART_DATE >=", value, "departDate");
            return (Criteria) this;
        }

        public Criteria andDepartDateLessThan(Date value) {
            addCriterion("DEPART_DATE <", value, "departDate");
            return (Criteria) this;
        }

        public Criteria andDepartDateLessThanOrEqualTo(Date value) {
            addCriterion("DEPART_DATE <=", value, "departDate");
            return (Criteria) this;
        }

        public Criteria andDepartDateIn(List<Date> values) {
            addCriterion("DEPART_DATE in", values, "departDate");
            return (Criteria) this;
        }

        public Criteria andDepartDateNotIn(List<Date> values) {
            addCriterion("DEPART_DATE not in", values, "departDate");
            return (Criteria) this;
        }

        public Criteria andDepartDateBetween(Date value1, Date value2) {
            addCriterion("DEPART_DATE between", value1, value2, "departDate");
            return (Criteria) this;
        }

        public Criteria andDepartDateNotBetween(Date value1, Date value2) {
            addCriterion("DEPART_DATE not between", value1, value2, "departDate");
            return (Criteria) this;
        }

        public Criteria andTaskTimeCostIsNull() {
            addCriterion("TASK_TIME_COST is null");
            return (Criteria) this;
        }

        public Criteria andTaskTimeCostIsNotNull() {
            addCriterion("TASK_TIME_COST is not null");
            return (Criteria) this;
        }

        public Criteria andTaskTimeCostEqualTo(Long value) {
            addCriterion("TASK_TIME_COST =", value, "taskTimeCost");
            return (Criteria) this;
        }

        public Criteria andTaskTimeCostNotEqualTo(Long value) {
            addCriterion("TASK_TIME_COST <>", value, "taskTimeCost");
            return (Criteria) this;
        }

        public Criteria andTaskTimeCostGreaterThan(Long value) {
            addCriterion("TASK_TIME_COST >", value, "taskTimeCost");
            return (Criteria) this;
        }

        public Criteria andTaskTimeCostGreaterThanOrEqualTo(Long value) {
            addCriterion("TASK_TIME_COST >=", value, "taskTimeCost");
            return (Criteria) this;
        }

        public Criteria andTaskTimeCostLessThan(Long value) {
            addCriterion("TASK_TIME_COST <", value, "taskTimeCost");
            return (Criteria) this;
        }

        public Criteria andTaskTimeCostLessThanOrEqualTo(Long value) {
            addCriterion("TASK_TIME_COST <=", value, "taskTimeCost");
            return (Criteria) this;
        }

        public Criteria andTaskTimeCostIn(List<Long> values) {
            addCriterion("TASK_TIME_COST in", values, "taskTimeCost");
            return (Criteria) this;
        }

        public Criteria andTaskTimeCostNotIn(List<Long> values) {
            addCriterion("TASK_TIME_COST not in", values, "taskTimeCost");
            return (Criteria) this;
        }

        public Criteria andTaskTimeCostBetween(Long value1, Long value2) {
            addCriterion("TASK_TIME_COST between", value1, value2, "taskTimeCost");
            return (Criteria) this;
        }

        public Criteria andTaskTimeCostNotBetween(Long value1, Long value2) {
            addCriterion("TASK_TIME_COST not between", value1, value2, "taskTimeCost");
            return (Criteria) this;
        }

        public Criteria andResultTypeIsNull() {
            addCriterion("RESULT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andResultTypeIsNotNull() {
            addCriterion("RESULT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andResultTypeEqualTo(String value) {
            addCriterion("RESULT_TYPE =", value, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeNotEqualTo(String value) {
            addCriterion("RESULT_TYPE <>", value, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeGreaterThan(String value) {
            addCriterion("RESULT_TYPE >", value, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeGreaterThanOrEqualTo(String value) {
            addCriterion("RESULT_TYPE >=", value, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeLessThan(String value) {
            addCriterion("RESULT_TYPE <", value, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeLessThanOrEqualTo(String value) {
            addCriterion("RESULT_TYPE <=", value, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeLike(String value) {
            addCriterion("RESULT_TYPE like", value, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeNotLike(String value) {
            addCriterion("RESULT_TYPE not like", value, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeIn(List<String> values) {
            addCriterion("RESULT_TYPE in", values, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeNotIn(List<String> values) {
            addCriterion("RESULT_TYPE not in", values, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeBetween(String value1, String value2) {
            addCriterion("RESULT_TYPE between", value1, value2, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeNotBetween(String value1, String value2) {
            addCriterion("RESULT_TYPE not between", value1, value2, "resultType");
            return (Criteria) this;
        }

        public Criteria andTokenIsNull() {
            addCriterion("TOKEN is null");
            return (Criteria) this;
        }

        public Criteria andTokenIsNotNull() {
            addCriterion("TOKEN is not null");
            return (Criteria) this;
        }

        public Criteria andTokenEqualTo(String value) {
            addCriterion("TOKEN =", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotEqualTo(String value) {
            addCriterion("TOKEN <>", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenGreaterThan(String value) {
            addCriterion("TOKEN >", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenGreaterThanOrEqualTo(String value) {
            addCriterion("TOKEN >=", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLessThan(String value) {
            addCriterion("TOKEN <", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLessThanOrEqualTo(String value) {
            addCriterion("TOKEN <=", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLike(String value) {
            addCriterion("TOKEN like", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotLike(String value) {
            addCriterion("TOKEN not like", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenIn(List<String> values) {
            addCriterion("TOKEN in", values, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotIn(List<String> values) {
            addCriterion("TOKEN not in", values, "token");
            return (Criteria) this;
        }

        public Criteria andTokenBetween(String value1, String value2) {
            addCriterion("TOKEN between", value1, value2, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotBetween(String value1, String value2) {
            addCriterion("TOKEN not between", value1, value2, "token");
            return (Criteria) this;
        }

        public Criteria andTaskIdLikeInsensitive(String value) {
            addCriterion("upper(TASK_ID) like", value.toUpperCase(), "taskId");
            return (Criteria) this;
        }

        public Criteria andDepartCodeLikeInsensitive(String value) {
            addCriterion("upper(DEPART_CODE) like", value.toUpperCase(), "departCode");
            return (Criteria) this;
        }

        public Criteria andArriveCodeLikeInsensitive(String value) {
            addCriterion("upper(ARRIVE_CODE) like", value.toUpperCase(), "arriveCode");
            return (Criteria) this;
        }

        public Criteria andResultTypeLikeInsensitive(String value) {
            addCriterion("upper(RESULT_TYPE) like", value.toUpperCase(), "resultType");
            return (Criteria) this;
        }

        public Criteria andTokenLikeInsensitive(String value) {
            addCriterion("upper(TOKEN) like", value.toUpperCase(), "token");
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