package com.jike.system.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DetectInterfaceLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public DetectInterfaceLogExample() {
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

        public Criteria andItfLogIdIsNull() {
            addCriterion("ITF_LOG_ID is null");
            return (Criteria) this;
        }

        public Criteria andItfLogIdIsNotNull() {
            addCriterion("ITF_LOG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andItfLogIdEqualTo(String value) {
            addCriterion("ITF_LOG_ID =", value, "itfLogId");
            return (Criteria) this;
        }

        public Criteria andItfLogIdNotEqualTo(String value) {
            addCriterion("ITF_LOG_ID <>", value, "itfLogId");
            return (Criteria) this;
        }

        public Criteria andItfLogIdGreaterThan(String value) {
            addCriterion("ITF_LOG_ID >", value, "itfLogId");
            return (Criteria) this;
        }

        public Criteria andItfLogIdGreaterThanOrEqualTo(String value) {
            addCriterion("ITF_LOG_ID >=", value, "itfLogId");
            return (Criteria) this;
        }

        public Criteria andItfLogIdLessThan(String value) {
            addCriterion("ITF_LOG_ID <", value, "itfLogId");
            return (Criteria) this;
        }

        public Criteria andItfLogIdLessThanOrEqualTo(String value) {
            addCriterion("ITF_LOG_ID <=", value, "itfLogId");
            return (Criteria) this;
        }

        public Criteria andItfLogIdLike(String value) {
            addCriterion("ITF_LOG_ID like", value, "itfLogId");
            return (Criteria) this;
        }

        public Criteria andItfLogIdNotLike(String value) {
            addCriterion("ITF_LOG_ID not like", value, "itfLogId");
            return (Criteria) this;
        }

        public Criteria andItfLogIdIn(List<String> values) {
            addCriterion("ITF_LOG_ID in", values, "itfLogId");
            return (Criteria) this;
        }

        public Criteria andItfLogIdNotIn(List<String> values) {
            addCriterion("ITF_LOG_ID not in", values, "itfLogId");
            return (Criteria) this;
        }

        public Criteria andItfLogIdBetween(String value1, String value2) {
            addCriterion("ITF_LOG_ID between", value1, value2, "itfLogId");
            return (Criteria) this;
        }

        public Criteria andItfLogIdNotBetween(String value1, String value2) {
            addCriterion("ITF_LOG_ID not between", value1, value2, "itfLogId");
            return (Criteria) this;
        }

        public Criteria andDetectTimeIsNull() {
            addCriterion("DETECT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andDetectTimeIsNotNull() {
            addCriterion("DETECT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andDetectTimeEqualTo(Date value) {
            addCriterion("DETECT_TIME =", value, "detectTime");
            return (Criteria) this;
        }

        public Criteria andDetectTimeNotEqualTo(Date value) {
            addCriterion("DETECT_TIME <>", value, "detectTime");
            return (Criteria) this;
        }

        public Criteria andDetectTimeGreaterThan(Date value) {
            addCriterion("DETECT_TIME >", value, "detectTime");
            return (Criteria) this;
        }

        public Criteria andDetectTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("DETECT_TIME >=", value, "detectTime");
            return (Criteria) this;
        }

        public Criteria andDetectTimeLessThan(Date value) {
            addCriterion("DETECT_TIME <", value, "detectTime");
            return (Criteria) this;
        }

        public Criteria andDetectTimeLessThanOrEqualTo(Date value) {
            addCriterion("DETECT_TIME <=", value, "detectTime");
            return (Criteria) this;
        }

        public Criteria andDetectTimeIn(List<Date> values) {
            addCriterion("DETECT_TIME in", values, "detectTime");
            return (Criteria) this;
        }

        public Criteria andDetectTimeNotIn(List<Date> values) {
            addCriterion("DETECT_TIME not in", values, "detectTime");
            return (Criteria) this;
        }

        public Criteria andDetectTimeBetween(Date value1, Date value2) {
            addCriterion("DETECT_TIME between", value1, value2, "detectTime");
            return (Criteria) this;
        }

        public Criteria andDetectTimeNotBetween(Date value1, Date value2) {
            addCriterion("DETECT_TIME not between", value1, value2, "detectTime");
            return (Criteria) this;
        }

        public Criteria andItfIdIsNull() {
            addCriterion("ITF_ID is null");
            return (Criteria) this;
        }

        public Criteria andItfIdIsNotNull() {
            addCriterion("ITF_ID is not null");
            return (Criteria) this;
        }

        public Criteria andItfIdEqualTo(String value) {
            addCriterion("ITF_ID =", value, "itfId");
            return (Criteria) this;
        }

        public Criteria andItfIdNotEqualTo(String value) {
            addCriterion("ITF_ID <>", value, "itfId");
            return (Criteria) this;
        }

        public Criteria andItfIdGreaterThan(String value) {
            addCriterion("ITF_ID >", value, "itfId");
            return (Criteria) this;
        }

        public Criteria andItfIdGreaterThanOrEqualTo(String value) {
            addCriterion("ITF_ID >=", value, "itfId");
            return (Criteria) this;
        }

        public Criteria andItfIdLessThan(String value) {
            addCriterion("ITF_ID <", value, "itfId");
            return (Criteria) this;
        }

        public Criteria andItfIdLessThanOrEqualTo(String value) {
            addCriterion("ITF_ID <=", value, "itfId");
            return (Criteria) this;
        }

        public Criteria andItfIdLike(String value) {
            addCriterion("ITF_ID like", value, "itfId");
            return (Criteria) this;
        }

        public Criteria andItfIdNotLike(String value) {
            addCriterion("ITF_ID not like", value, "itfId");
            return (Criteria) this;
        }

        public Criteria andItfIdIn(List<String> values) {
            addCriterion("ITF_ID in", values, "itfId");
            return (Criteria) this;
        }

        public Criteria andItfIdNotIn(List<String> values) {
            addCriterion("ITF_ID not in", values, "itfId");
            return (Criteria) this;
        }

        public Criteria andItfIdBetween(String value1, String value2) {
            addCriterion("ITF_ID between", value1, value2, "itfId");
            return (Criteria) this;
        }

        public Criteria andItfIdNotBetween(String value1, String value2) {
            addCriterion("ITF_ID not between", value1, value2, "itfId");
            return (Criteria) this;
        }

        public Criteria andInputParamsIsNull() {
            addCriterion("INPUT_PARAMS is null");
            return (Criteria) this;
        }

        public Criteria andInputParamsIsNotNull() {
            addCriterion("INPUT_PARAMS is not null");
            return (Criteria) this;
        }

        public Criteria andInputParamsEqualTo(String value) {
            addCriterion("INPUT_PARAMS =", value, "inputParams");
            return (Criteria) this;
        }

        public Criteria andInputParamsNotEqualTo(String value) {
            addCriterion("INPUT_PARAMS <>", value, "inputParams");
            return (Criteria) this;
        }

        public Criteria andInputParamsGreaterThan(String value) {
            addCriterion("INPUT_PARAMS >", value, "inputParams");
            return (Criteria) this;
        }

        public Criteria andInputParamsGreaterThanOrEqualTo(String value) {
            addCriterion("INPUT_PARAMS >=", value, "inputParams");
            return (Criteria) this;
        }

        public Criteria andInputParamsLessThan(String value) {
            addCriterion("INPUT_PARAMS <", value, "inputParams");
            return (Criteria) this;
        }

        public Criteria andInputParamsLessThanOrEqualTo(String value) {
            addCriterion("INPUT_PARAMS <=", value, "inputParams");
            return (Criteria) this;
        }

        public Criteria andInputParamsLike(String value) {
            addCriterion("INPUT_PARAMS like", value, "inputParams");
            return (Criteria) this;
        }

        public Criteria andInputParamsNotLike(String value) {
            addCriterion("INPUT_PARAMS not like", value, "inputParams");
            return (Criteria) this;
        }

        public Criteria andInputParamsIn(List<String> values) {
            addCriterion("INPUT_PARAMS in", values, "inputParams");
            return (Criteria) this;
        }

        public Criteria andInputParamsNotIn(List<String> values) {
            addCriterion("INPUT_PARAMS not in", values, "inputParams");
            return (Criteria) this;
        }

        public Criteria andInputParamsBetween(String value1, String value2) {
            addCriterion("INPUT_PARAMS between", value1, value2, "inputParams");
            return (Criteria) this;
        }

        public Criteria andInputParamsNotBetween(String value1, String value2) {
            addCriterion("INPUT_PARAMS not between", value1, value2, "inputParams");
            return (Criteria) this;
        }

        public Criteria andDetectResultIsNull() {
            addCriterion("DETECT_RESULT is null");
            return (Criteria) this;
        }

        public Criteria andDetectResultIsNotNull() {
            addCriterion("DETECT_RESULT is not null");
            return (Criteria) this;
        }

        public Criteria andDetectResultEqualTo(String value) {
            addCriterion("DETECT_RESULT =", value, "detectResult");
            return (Criteria) this;
        }

        public Criteria andDetectResultNotEqualTo(String value) {
            addCriterion("DETECT_RESULT <>", value, "detectResult");
            return (Criteria) this;
        }

        public Criteria andDetectResultGreaterThan(String value) {
            addCriterion("DETECT_RESULT >", value, "detectResult");
            return (Criteria) this;
        }

        public Criteria andDetectResultGreaterThanOrEqualTo(String value) {
            addCriterion("DETECT_RESULT >=", value, "detectResult");
            return (Criteria) this;
        }

        public Criteria andDetectResultLessThan(String value) {
            addCriterion("DETECT_RESULT <", value, "detectResult");
            return (Criteria) this;
        }

        public Criteria andDetectResultLessThanOrEqualTo(String value) {
            addCriterion("DETECT_RESULT <=", value, "detectResult");
            return (Criteria) this;
        }

        public Criteria andDetectResultLike(String value) {
            addCriterion("DETECT_RESULT like", value, "detectResult");
            return (Criteria) this;
        }

        public Criteria andDetectResultNotLike(String value) {
            addCriterion("DETECT_RESULT not like", value, "detectResult");
            return (Criteria) this;
        }

        public Criteria andDetectResultIn(List<String> values) {
            addCriterion("DETECT_RESULT in", values, "detectResult");
            return (Criteria) this;
        }

        public Criteria andDetectResultNotIn(List<String> values) {
            addCriterion("DETECT_RESULT not in", values, "detectResult");
            return (Criteria) this;
        }

        public Criteria andDetectResultBetween(String value1, String value2) {
            addCriterion("DETECT_RESULT between", value1, value2, "detectResult");
            return (Criteria) this;
        }

        public Criteria andDetectResultNotBetween(String value1, String value2) {
            addCriterion("DETECT_RESULT not between", value1, value2, "detectResult");
            return (Criteria) this;
        }

        public Criteria andErrorInfoIsNull() {
            addCriterion("ERROR_INFO is null");
            return (Criteria) this;
        }

        public Criteria andErrorInfoIsNotNull() {
            addCriterion("ERROR_INFO is not null");
            return (Criteria) this;
        }

        public Criteria andErrorInfoEqualTo(String value) {
            addCriterion("ERROR_INFO =", value, "errorInfo");
            return (Criteria) this;
        }

        public Criteria andErrorInfoNotEqualTo(String value) {
            addCriterion("ERROR_INFO <>", value, "errorInfo");
            return (Criteria) this;
        }

        public Criteria andErrorInfoGreaterThan(String value) {
            addCriterion("ERROR_INFO >", value, "errorInfo");
            return (Criteria) this;
        }

        public Criteria andErrorInfoGreaterThanOrEqualTo(String value) {
            addCriterion("ERROR_INFO >=", value, "errorInfo");
            return (Criteria) this;
        }

        public Criteria andErrorInfoLessThan(String value) {
            addCriterion("ERROR_INFO <", value, "errorInfo");
            return (Criteria) this;
        }

        public Criteria andErrorInfoLessThanOrEqualTo(String value) {
            addCriterion("ERROR_INFO <=", value, "errorInfo");
            return (Criteria) this;
        }

        public Criteria andErrorInfoLike(String value) {
            addCriterion("ERROR_INFO like", value, "errorInfo");
            return (Criteria) this;
        }

        public Criteria andErrorInfoNotLike(String value) {
            addCriterion("ERROR_INFO not like", value, "errorInfo");
            return (Criteria) this;
        }

        public Criteria andErrorInfoIn(List<String> values) {
            addCriterion("ERROR_INFO in", values, "errorInfo");
            return (Criteria) this;
        }

        public Criteria andErrorInfoNotIn(List<String> values) {
            addCriterion("ERROR_INFO not in", values, "errorInfo");
            return (Criteria) this;
        }

        public Criteria andErrorInfoBetween(String value1, String value2) {
            addCriterion("ERROR_INFO between", value1, value2, "errorInfo");
            return (Criteria) this;
        }

        public Criteria andErrorInfoNotBetween(String value1, String value2) {
            addCriterion("ERROR_INFO not between", value1, value2, "errorInfo");
            return (Criteria) this;
        }

        public Criteria andItfLogIdLikeInsensitive(String value) {
            addCriterion("upper(ITF_LOG_ID) like", value.toUpperCase(), "itfLogId");
            return (Criteria) this;
        }

        public Criteria andItfIdLikeInsensitive(String value) {
            addCriterion("upper(ITF_ID) like", value.toUpperCase(), "itfId");
            return (Criteria) this;
        }

        public Criteria andInputParamsLikeInsensitive(String value) {
            addCriterion("upper(INPUT_PARAMS) like", value.toUpperCase(), "inputParams");
            return (Criteria) this;
        }

        public Criteria andDetectResultLikeInsensitive(String value) {
            addCriterion("upper(DETECT_RESULT) like", value.toUpperCase(), "detectResult");
            return (Criteria) this;
        }

        public Criteria andErrorInfoLikeInsensitive(String value) {
            addCriterion("upper(ERROR_INFO) like", value.toUpperCase(), "errorInfo");
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