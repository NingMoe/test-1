package com.jike.system.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DetectInterfaceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public DetectInterfaceExample() {
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

        public Criteria andTaskGroupIdIsNull() {
            addCriterion("TASK_GROUP_ID is null");
            return (Criteria) this;
        }

        public Criteria andTaskGroupIdIsNotNull() {
            addCriterion("TASK_GROUP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTaskGroupIdEqualTo(String value) {
            addCriterion("TASK_GROUP_ID =", value, "taskGroupId");
            return (Criteria) this;
        }

        public Criteria andTaskGroupIdNotEqualTo(String value) {
            addCriterion("TASK_GROUP_ID <>", value, "taskGroupId");
            return (Criteria) this;
        }

        public Criteria andTaskGroupIdGreaterThan(String value) {
            addCriterion("TASK_GROUP_ID >", value, "taskGroupId");
            return (Criteria) this;
        }

        public Criteria andTaskGroupIdGreaterThanOrEqualTo(String value) {
            addCriterion("TASK_GROUP_ID >=", value, "taskGroupId");
            return (Criteria) this;
        }

        public Criteria andTaskGroupIdLessThan(String value) {
            addCriterion("TASK_GROUP_ID <", value, "taskGroupId");
            return (Criteria) this;
        }

        public Criteria andTaskGroupIdLessThanOrEqualTo(String value) {
            addCriterion("TASK_GROUP_ID <=", value, "taskGroupId");
            return (Criteria) this;
        }

        public Criteria andTaskGroupIdLike(String value) {
            addCriterion("TASK_GROUP_ID like", value, "taskGroupId");
            return (Criteria) this;
        }

        public Criteria andTaskGroupIdNotLike(String value) {
            addCriterion("TASK_GROUP_ID not like", value, "taskGroupId");
            return (Criteria) this;
        }

        public Criteria andTaskGroupIdIn(List<String> values) {
            addCriterion("TASK_GROUP_ID in", values, "taskGroupId");
            return (Criteria) this;
        }

        public Criteria andTaskGroupIdNotIn(List<String> values) {
            addCriterion("TASK_GROUP_ID not in", values, "taskGroupId");
            return (Criteria) this;
        }

        public Criteria andTaskGroupIdBetween(String value1, String value2) {
            addCriterion("TASK_GROUP_ID between", value1, value2, "taskGroupId");
            return (Criteria) this;
        }

        public Criteria andTaskGroupIdNotBetween(String value1, String value2) {
            addCriterion("TASK_GROUP_ID not between", value1, value2, "taskGroupId");
            return (Criteria) this;
        }

        public Criteria andBelongToIsNull() {
            addCriterion("BELONG_TO is null");
            return (Criteria) this;
        }

        public Criteria andBelongToIsNotNull() {
            addCriterion("BELONG_TO is not null");
            return (Criteria) this;
        }

        public Criteria andBelongToEqualTo(String value) {
            addCriterion("BELONG_TO =", value, "belongTo");
            return (Criteria) this;
        }

        public Criteria andBelongToNotEqualTo(String value) {
            addCriterion("BELONG_TO <>", value, "belongTo");
            return (Criteria) this;
        }

        public Criteria andBelongToGreaterThan(String value) {
            addCriterion("BELONG_TO >", value, "belongTo");
            return (Criteria) this;
        }

        public Criteria andBelongToGreaterThanOrEqualTo(String value) {
            addCriterion("BELONG_TO >=", value, "belongTo");
            return (Criteria) this;
        }

        public Criteria andBelongToLessThan(String value) {
            addCriterion("BELONG_TO <", value, "belongTo");
            return (Criteria) this;
        }

        public Criteria andBelongToLessThanOrEqualTo(String value) {
            addCriterion("BELONG_TO <=", value, "belongTo");
            return (Criteria) this;
        }

        public Criteria andBelongToLike(String value) {
            addCriterion("BELONG_TO like", value, "belongTo");
            return (Criteria) this;
        }

        public Criteria andBelongToNotLike(String value) {
            addCriterion("BELONG_TO not like", value, "belongTo");
            return (Criteria) this;
        }

        public Criteria andBelongToIn(List<String> values) {
            addCriterion("BELONG_TO in", values, "belongTo");
            return (Criteria) this;
        }

        public Criteria andBelongToNotIn(List<String> values) {
            addCriterion("BELONG_TO not in", values, "belongTo");
            return (Criteria) this;
        }

        public Criteria andBelongToBetween(String value1, String value2) {
            addCriterion("BELONG_TO between", value1, value2, "belongTo");
            return (Criteria) this;
        }

        public Criteria andBelongToNotBetween(String value1, String value2) {
            addCriterion("BELONG_TO not between", value1, value2, "belongTo");
            return (Criteria) this;
        }

        public Criteria andItfUrlIsNull() {
            addCriterion("ITF_URL is null");
            return (Criteria) this;
        }

        public Criteria andItfUrlIsNotNull() {
            addCriterion("ITF_URL is not null");
            return (Criteria) this;
        }

        public Criteria andItfUrlEqualTo(String value) {
            addCriterion("ITF_URL =", value, "itfUrl");
            return (Criteria) this;
        }

        public Criteria andItfUrlNotEqualTo(String value) {
            addCriterion("ITF_URL <>", value, "itfUrl");
            return (Criteria) this;
        }

        public Criteria andItfUrlGreaterThan(String value) {
            addCriterion("ITF_URL >", value, "itfUrl");
            return (Criteria) this;
        }

        public Criteria andItfUrlGreaterThanOrEqualTo(String value) {
            addCriterion("ITF_URL >=", value, "itfUrl");
            return (Criteria) this;
        }

        public Criteria andItfUrlLessThan(String value) {
            addCriterion("ITF_URL <", value, "itfUrl");
            return (Criteria) this;
        }

        public Criteria andItfUrlLessThanOrEqualTo(String value) {
            addCriterion("ITF_URL <=", value, "itfUrl");
            return (Criteria) this;
        }

        public Criteria andItfUrlLike(String value) {
            addCriterion("ITF_URL like", value, "itfUrl");
            return (Criteria) this;
        }

        public Criteria andItfUrlNotLike(String value) {
            addCriterion("ITF_URL not like", value, "itfUrl");
            return (Criteria) this;
        }

        public Criteria andItfUrlIn(List<String> values) {
            addCriterion("ITF_URL in", values, "itfUrl");
            return (Criteria) this;
        }

        public Criteria andItfUrlNotIn(List<String> values) {
            addCriterion("ITF_URL not in", values, "itfUrl");
            return (Criteria) this;
        }

        public Criteria andItfUrlBetween(String value1, String value2) {
            addCriterion("ITF_URL between", value1, value2, "itfUrl");
            return (Criteria) this;
        }

        public Criteria andItfUrlNotBetween(String value1, String value2) {
            addCriterion("ITF_URL not between", value1, value2, "itfUrl");
            return (Criteria) this;
        }

        public Criteria andItfParamsIsNull() {
            addCriterion("ITF_PARAMS is null");
            return (Criteria) this;
        }

        public Criteria andItfParamsIsNotNull() {
            addCriterion("ITF_PARAMS is not null");
            return (Criteria) this;
        }

        public Criteria andItfParamsEqualTo(String value) {
            addCriterion("ITF_PARAMS =", value, "itfParams");
            return (Criteria) this;
        }

        public Criteria andItfParamsNotEqualTo(String value) {
            addCriterion("ITF_PARAMS <>", value, "itfParams");
            return (Criteria) this;
        }

        public Criteria andItfParamsGreaterThan(String value) {
            addCriterion("ITF_PARAMS >", value, "itfParams");
            return (Criteria) this;
        }

        public Criteria andItfParamsGreaterThanOrEqualTo(String value) {
            addCriterion("ITF_PARAMS >=", value, "itfParams");
            return (Criteria) this;
        }

        public Criteria andItfParamsLessThan(String value) {
            addCriterion("ITF_PARAMS <", value, "itfParams");
            return (Criteria) this;
        }

        public Criteria andItfParamsLessThanOrEqualTo(String value) {
            addCriterion("ITF_PARAMS <=", value, "itfParams");
            return (Criteria) this;
        }

        public Criteria andItfParamsLike(String value) {
            addCriterion("ITF_PARAMS like", value, "itfParams");
            return (Criteria) this;
        }

        public Criteria andItfParamsNotLike(String value) {
            addCriterion("ITF_PARAMS not like", value, "itfParams");
            return (Criteria) this;
        }

        public Criteria andItfParamsIn(List<String> values) {
            addCriterion("ITF_PARAMS in", values, "itfParams");
            return (Criteria) this;
        }

        public Criteria andItfParamsNotIn(List<String> values) {
            addCriterion("ITF_PARAMS not in", values, "itfParams");
            return (Criteria) this;
        }

        public Criteria andItfParamsBetween(String value1, String value2) {
            addCriterion("ITF_PARAMS between", value1, value2, "itfParams");
            return (Criteria) this;
        }

        public Criteria andItfParamsNotBetween(String value1, String value2) {
            addCriterion("ITF_PARAMS not between", value1, value2, "itfParams");
            return (Criteria) this;
        }

        public Criteria andRequestMethodIsNull() {
            addCriterion("REQUEST_METHOD is null");
            return (Criteria) this;
        }

        public Criteria andRequestMethodIsNotNull() {
            addCriterion("REQUEST_METHOD is not null");
            return (Criteria) this;
        }

        public Criteria andRequestMethodEqualTo(String value) {
            addCriterion("REQUEST_METHOD =", value, "requestMethod");
            return (Criteria) this;
        }

        public Criteria andRequestMethodNotEqualTo(String value) {
            addCriterion("REQUEST_METHOD <>", value, "requestMethod");
            return (Criteria) this;
        }

        public Criteria andRequestMethodGreaterThan(String value) {
            addCriterion("REQUEST_METHOD >", value, "requestMethod");
            return (Criteria) this;
        }

        public Criteria andRequestMethodGreaterThanOrEqualTo(String value) {
            addCriterion("REQUEST_METHOD >=", value, "requestMethod");
            return (Criteria) this;
        }

        public Criteria andRequestMethodLessThan(String value) {
            addCriterion("REQUEST_METHOD <", value, "requestMethod");
            return (Criteria) this;
        }

        public Criteria andRequestMethodLessThanOrEqualTo(String value) {
            addCriterion("REQUEST_METHOD <=", value, "requestMethod");
            return (Criteria) this;
        }

        public Criteria andRequestMethodLike(String value) {
            addCriterion("REQUEST_METHOD like", value, "requestMethod");
            return (Criteria) this;
        }

        public Criteria andRequestMethodNotLike(String value) {
            addCriterion("REQUEST_METHOD not like", value, "requestMethod");
            return (Criteria) this;
        }

        public Criteria andRequestMethodIn(List<String> values) {
            addCriterion("REQUEST_METHOD in", values, "requestMethod");
            return (Criteria) this;
        }

        public Criteria andRequestMethodNotIn(List<String> values) {
            addCriterion("REQUEST_METHOD not in", values, "requestMethod");
            return (Criteria) this;
        }

        public Criteria andRequestMethodBetween(String value1, String value2) {
            addCriterion("REQUEST_METHOD between", value1, value2, "requestMethod");
            return (Criteria) this;
        }

        public Criteria andRequestMethodNotBetween(String value1, String value2) {
            addCriterion("REQUEST_METHOD not between", value1, value2, "requestMethod");
            return (Criteria) this;
        }

        public Criteria andCheckKeyIsNull() {
            addCriterion("CHECK_KEY is null");
            return (Criteria) this;
        }

        public Criteria andCheckKeyIsNotNull() {
            addCriterion("CHECK_KEY is not null");
            return (Criteria) this;
        }

        public Criteria andCheckKeyEqualTo(String value) {
            addCriterion("CHECK_KEY =", value, "checkKey");
            return (Criteria) this;
        }

        public Criteria andCheckKeyNotEqualTo(String value) {
            addCriterion("CHECK_KEY <>", value, "checkKey");
            return (Criteria) this;
        }

        public Criteria andCheckKeyGreaterThan(String value) {
            addCriterion("CHECK_KEY >", value, "checkKey");
            return (Criteria) this;
        }

        public Criteria andCheckKeyGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_KEY >=", value, "checkKey");
            return (Criteria) this;
        }

        public Criteria andCheckKeyLessThan(String value) {
            addCriterion("CHECK_KEY <", value, "checkKey");
            return (Criteria) this;
        }

        public Criteria andCheckKeyLessThanOrEqualTo(String value) {
            addCriterion("CHECK_KEY <=", value, "checkKey");
            return (Criteria) this;
        }

        public Criteria andCheckKeyLike(String value) {
            addCriterion("CHECK_KEY like", value, "checkKey");
            return (Criteria) this;
        }

        public Criteria andCheckKeyNotLike(String value) {
            addCriterion("CHECK_KEY not like", value, "checkKey");
            return (Criteria) this;
        }

        public Criteria andCheckKeyIn(List<String> values) {
            addCriterion("CHECK_KEY in", values, "checkKey");
            return (Criteria) this;
        }

        public Criteria andCheckKeyNotIn(List<String> values) {
            addCriterion("CHECK_KEY not in", values, "checkKey");
            return (Criteria) this;
        }

        public Criteria andCheckKeyBetween(String value1, String value2) {
            addCriterion("CHECK_KEY between", value1, value2, "checkKey");
            return (Criteria) this;
        }

        public Criteria andCheckKeyNotBetween(String value1, String value2) {
            addCriterion("CHECK_KEY not between", value1, value2, "checkKey");
            return (Criteria) this;
        }

        public Criteria andCheckValueIsNull() {
            addCriterion("CHECK_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andCheckValueIsNotNull() {
            addCriterion("CHECK_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andCheckValueEqualTo(String value) {
            addCriterion("CHECK_VALUE =", value, "checkValue");
            return (Criteria) this;
        }

        public Criteria andCheckValueNotEqualTo(String value) {
            addCriterion("CHECK_VALUE <>", value, "checkValue");
            return (Criteria) this;
        }

        public Criteria andCheckValueGreaterThan(String value) {
            addCriterion("CHECK_VALUE >", value, "checkValue");
            return (Criteria) this;
        }

        public Criteria andCheckValueGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_VALUE >=", value, "checkValue");
            return (Criteria) this;
        }

        public Criteria andCheckValueLessThan(String value) {
            addCriterion("CHECK_VALUE <", value, "checkValue");
            return (Criteria) this;
        }

        public Criteria andCheckValueLessThanOrEqualTo(String value) {
            addCriterion("CHECK_VALUE <=", value, "checkValue");
            return (Criteria) this;
        }

        public Criteria andCheckValueLike(String value) {
            addCriterion("CHECK_VALUE like", value, "checkValue");
            return (Criteria) this;
        }

        public Criteria andCheckValueNotLike(String value) {
            addCriterion("CHECK_VALUE not like", value, "checkValue");
            return (Criteria) this;
        }

        public Criteria andCheckValueIn(List<String> values) {
            addCriterion("CHECK_VALUE in", values, "checkValue");
            return (Criteria) this;
        }

        public Criteria andCheckValueNotIn(List<String> values) {
            addCriterion("CHECK_VALUE not in", values, "checkValue");
            return (Criteria) this;
        }

        public Criteria andCheckValueBetween(String value1, String value2) {
            addCriterion("CHECK_VALUE between", value1, value2, "checkValue");
            return (Criteria) this;
        }

        public Criteria andCheckValueNotBetween(String value1, String value2) {
            addCriterion("CHECK_VALUE not between", value1, value2, "checkValue");
            return (Criteria) this;
        }

        public Criteria andDetectFrequencyIsNull() {
            addCriterion("DETECT_FREQUENCY is null");
            return (Criteria) this;
        }

        public Criteria andDetectFrequencyIsNotNull() {
            addCriterion("DETECT_FREQUENCY is not null");
            return (Criteria) this;
        }

        public Criteria andDetectFrequencyEqualTo(Integer value) {
            addCriterion("DETECT_FREQUENCY =", value, "detectFrequency");
            return (Criteria) this;
        }

        public Criteria andDetectFrequencyNotEqualTo(Integer value) {
            addCriterion("DETECT_FREQUENCY <>", value, "detectFrequency");
            return (Criteria) this;
        }

        public Criteria andDetectFrequencyGreaterThan(Integer value) {
            addCriterion("DETECT_FREQUENCY >", value, "detectFrequency");
            return (Criteria) this;
        }

        public Criteria andDetectFrequencyGreaterThanOrEqualTo(Integer value) {
            addCriterion("DETECT_FREQUENCY >=", value, "detectFrequency");
            return (Criteria) this;
        }

        public Criteria andDetectFrequencyLessThan(Integer value) {
            addCriterion("DETECT_FREQUENCY <", value, "detectFrequency");
            return (Criteria) this;
        }

        public Criteria andDetectFrequencyLessThanOrEqualTo(Integer value) {
            addCriterion("DETECT_FREQUENCY <=", value, "detectFrequency");
            return (Criteria) this;
        }

        public Criteria andDetectFrequencyIn(List<Integer> values) {
            addCriterion("DETECT_FREQUENCY in", values, "detectFrequency");
            return (Criteria) this;
        }

        public Criteria andDetectFrequencyNotIn(List<Integer> values) {
            addCriterion("DETECT_FREQUENCY not in", values, "detectFrequency");
            return (Criteria) this;
        }

        public Criteria andDetectFrequencyBetween(Integer value1, Integer value2) {
            addCriterion("DETECT_FREQUENCY between", value1, value2, "detectFrequency");
            return (Criteria) this;
        }

        public Criteria andDetectFrequencyNotBetween(Integer value1, Integer value2) {
            addCriterion("DETECT_FREQUENCY not between", value1, value2, "detectFrequency");
            return (Criteria) this;
        }

        public Criteria andThresholdValueIsNull() {
            addCriterion("THRESHOLD_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andThresholdValueIsNotNull() {
            addCriterion("THRESHOLD_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andThresholdValueEqualTo(Short value) {
            addCriterion("THRESHOLD_VALUE =", value, "thresholdValue");
            return (Criteria) this;
        }

        public Criteria andThresholdValueNotEqualTo(Short value) {
            addCriterion("THRESHOLD_VALUE <>", value, "thresholdValue");
            return (Criteria) this;
        }

        public Criteria andThresholdValueGreaterThan(Short value) {
            addCriterion("THRESHOLD_VALUE >", value, "thresholdValue");
            return (Criteria) this;
        }

        public Criteria andThresholdValueGreaterThanOrEqualTo(Short value) {
            addCriterion("THRESHOLD_VALUE >=", value, "thresholdValue");
            return (Criteria) this;
        }

        public Criteria andThresholdValueLessThan(Short value) {
            addCriterion("THRESHOLD_VALUE <", value, "thresholdValue");
            return (Criteria) this;
        }

        public Criteria andThresholdValueLessThanOrEqualTo(Short value) {
            addCriterion("THRESHOLD_VALUE <=", value, "thresholdValue");
            return (Criteria) this;
        }

        public Criteria andThresholdValueIn(List<Short> values) {
            addCriterion("THRESHOLD_VALUE in", values, "thresholdValue");
            return (Criteria) this;
        }

        public Criteria andThresholdValueNotIn(List<Short> values) {
            addCriterion("THRESHOLD_VALUE not in", values, "thresholdValue");
            return (Criteria) this;
        }

        public Criteria andThresholdValueBetween(Short value1, Short value2) {
            addCriterion("THRESHOLD_VALUE between", value1, value2, "thresholdValue");
            return (Criteria) this;
        }

        public Criteria andThresholdValueNotBetween(Short value1, Short value2) {
            addCriterion("THRESHOLD_VALUE not between", value1, value2, "thresholdValue");
            return (Criteria) this;
        }

        public Criteria andCurrentFailureNumIsNull() {
            addCriterion("CURRENT_FAILURE_NUM is null");
            return (Criteria) this;
        }

        public Criteria andCurrentFailureNumIsNotNull() {
            addCriterion("CURRENT_FAILURE_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentFailureNumEqualTo(Short value) {
            addCriterion("CURRENT_FAILURE_NUM =", value, "currentFailureNum");
            return (Criteria) this;
        }

        public Criteria andCurrentFailureNumNotEqualTo(Short value) {
            addCriterion("CURRENT_FAILURE_NUM <>", value, "currentFailureNum");
            return (Criteria) this;
        }

        public Criteria andCurrentFailureNumGreaterThan(Short value) {
            addCriterion("CURRENT_FAILURE_NUM >", value, "currentFailureNum");
            return (Criteria) this;
        }

        public Criteria andCurrentFailureNumGreaterThanOrEqualTo(Short value) {
            addCriterion("CURRENT_FAILURE_NUM >=", value, "currentFailureNum");
            return (Criteria) this;
        }

        public Criteria andCurrentFailureNumLessThan(Short value) {
            addCriterion("CURRENT_FAILURE_NUM <", value, "currentFailureNum");
            return (Criteria) this;
        }

        public Criteria andCurrentFailureNumLessThanOrEqualTo(Short value) {
            addCriterion("CURRENT_FAILURE_NUM <=", value, "currentFailureNum");
            return (Criteria) this;
        }

        public Criteria andCurrentFailureNumIn(List<Short> values) {
            addCriterion("CURRENT_FAILURE_NUM in", values, "currentFailureNum");
            return (Criteria) this;
        }

        public Criteria andCurrentFailureNumNotIn(List<Short> values) {
            addCriterion("CURRENT_FAILURE_NUM not in", values, "currentFailureNum");
            return (Criteria) this;
        }

        public Criteria andCurrentFailureNumBetween(Short value1, Short value2) {
            addCriterion("CURRENT_FAILURE_NUM between", value1, value2, "currentFailureNum");
            return (Criteria) this;
        }

        public Criteria andCurrentFailureNumNotBetween(Short value1, Short value2) {
            addCriterion("CURRENT_FAILURE_NUM not between", value1, value2, "currentFailureNum");
            return (Criteria) this;
        }

        public Criteria andNoticeLvlIsNull() {
            addCriterion("NOTICE_LVL is null");
            return (Criteria) this;
        }

        public Criteria andNoticeLvlIsNotNull() {
            addCriterion("NOTICE_LVL is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeLvlEqualTo(String value) {
            addCriterion("NOTICE_LVL =", value, "noticeLvl");
            return (Criteria) this;
        }

        public Criteria andNoticeLvlNotEqualTo(String value) {
            addCriterion("NOTICE_LVL <>", value, "noticeLvl");
            return (Criteria) this;
        }

        public Criteria andNoticeLvlGreaterThan(String value) {
            addCriterion("NOTICE_LVL >", value, "noticeLvl");
            return (Criteria) this;
        }

        public Criteria andNoticeLvlGreaterThanOrEqualTo(String value) {
            addCriterion("NOTICE_LVL >=", value, "noticeLvl");
            return (Criteria) this;
        }

        public Criteria andNoticeLvlLessThan(String value) {
            addCriterion("NOTICE_LVL <", value, "noticeLvl");
            return (Criteria) this;
        }

        public Criteria andNoticeLvlLessThanOrEqualTo(String value) {
            addCriterion("NOTICE_LVL <=", value, "noticeLvl");
            return (Criteria) this;
        }

        public Criteria andNoticeLvlLike(String value) {
            addCriterion("NOTICE_LVL like", value, "noticeLvl");
            return (Criteria) this;
        }

        public Criteria andNoticeLvlNotLike(String value) {
            addCriterion("NOTICE_LVL not like", value, "noticeLvl");
            return (Criteria) this;
        }

        public Criteria andNoticeLvlIn(List<String> values) {
            addCriterion("NOTICE_LVL in", values, "noticeLvl");
            return (Criteria) this;
        }

        public Criteria andNoticeLvlNotIn(List<String> values) {
            addCriterion("NOTICE_LVL not in", values, "noticeLvl");
            return (Criteria) this;
        }

        public Criteria andNoticeLvlBetween(String value1, String value2) {
            addCriterion("NOTICE_LVL between", value1, value2, "noticeLvl");
            return (Criteria) this;
        }

        public Criteria andNoticeLvlNotBetween(String value1, String value2) {
            addCriterion("NOTICE_LVL not between", value1, value2, "noticeLvl");
            return (Criteria) this;
        }

        public Criteria andNoticeObjectIsNull() {
            addCriterion("NOTICE_OBJECT is null");
            return (Criteria) this;
        }

        public Criteria andNoticeObjectIsNotNull() {
            addCriterion("NOTICE_OBJECT is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeObjectEqualTo(String value) {
            addCriterion("NOTICE_OBJECT =", value, "noticeObject");
            return (Criteria) this;
        }

        public Criteria andNoticeObjectNotEqualTo(String value) {
            addCriterion("NOTICE_OBJECT <>", value, "noticeObject");
            return (Criteria) this;
        }

        public Criteria andNoticeObjectGreaterThan(String value) {
            addCriterion("NOTICE_OBJECT >", value, "noticeObject");
            return (Criteria) this;
        }

        public Criteria andNoticeObjectGreaterThanOrEqualTo(String value) {
            addCriterion("NOTICE_OBJECT >=", value, "noticeObject");
            return (Criteria) this;
        }

        public Criteria andNoticeObjectLessThan(String value) {
            addCriterion("NOTICE_OBJECT <", value, "noticeObject");
            return (Criteria) this;
        }

        public Criteria andNoticeObjectLessThanOrEqualTo(String value) {
            addCriterion("NOTICE_OBJECT <=", value, "noticeObject");
            return (Criteria) this;
        }

        public Criteria andNoticeObjectLike(String value) {
            addCriterion("NOTICE_OBJECT like", value, "noticeObject");
            return (Criteria) this;
        }

        public Criteria andNoticeObjectNotLike(String value) {
            addCriterion("NOTICE_OBJECT not like", value, "noticeObject");
            return (Criteria) this;
        }

        public Criteria andNoticeObjectIn(List<String> values) {
            addCriterion("NOTICE_OBJECT in", values, "noticeObject");
            return (Criteria) this;
        }

        public Criteria andNoticeObjectNotIn(List<String> values) {
            addCriterion("NOTICE_OBJECT not in", values, "noticeObject");
            return (Criteria) this;
        }

        public Criteria andNoticeObjectBetween(String value1, String value2) {
            addCriterion("NOTICE_OBJECT between", value1, value2, "noticeObject");
            return (Criteria) this;
        }

        public Criteria andNoticeObjectNotBetween(String value1, String value2) {
            addCriterion("NOTICE_OBJECT not between", value1, value2, "noticeObject");
            return (Criteria) this;
        }

        public Criteria andByProxyIsNull() {
            addCriterion("BY_PROXY is null");
            return (Criteria) this;
        }

        public Criteria andByProxyIsNotNull() {
            addCriterion("BY_PROXY is not null");
            return (Criteria) this;
        }

        public Criteria andByProxyEqualTo(Boolean value) {
            addCriterion("BY_PROXY =", value, "byProxy");
            return (Criteria) this;
        }

        public Criteria andByProxyNotEqualTo(Boolean value) {
            addCriterion("BY_PROXY <>", value, "byProxy");
            return (Criteria) this;
        }

        public Criteria andByProxyGreaterThan(Boolean value) {
            addCriterion("BY_PROXY >", value, "byProxy");
            return (Criteria) this;
        }

        public Criteria andByProxyGreaterThanOrEqualTo(Boolean value) {
            addCriterion("BY_PROXY >=", value, "byProxy");
            return (Criteria) this;
        }

        public Criteria andByProxyLessThan(Boolean value) {
            addCriterion("BY_PROXY <", value, "byProxy");
            return (Criteria) this;
        }

        public Criteria andByProxyLessThanOrEqualTo(Boolean value) {
            addCriterion("BY_PROXY <=", value, "byProxy");
            return (Criteria) this;
        }

        public Criteria andByProxyLike(Boolean value) {
            addCriterion("BY_PROXY like", value, "byProxy");
            return (Criteria) this;
        }

        public Criteria andByProxyNotLike(Boolean value) {
            addCriterion("BY_PROXY not like", value, "byProxy");
            return (Criteria) this;
        }

        public Criteria andByProxyIn(List<Boolean> values) {
            addCriterion("BY_PROXY in", values, "byProxy");
            return (Criteria) this;
        }

        public Criteria andByProxyNotIn(List<Boolean> values) {
            addCriterion("BY_PROXY not in", values, "byProxy");
            return (Criteria) this;
        }

        public Criteria andByProxyBetween(Boolean value1, Boolean value2) {
            addCriterion("BY_PROXY between", value1, value2, "byProxy");
            return (Criteria) this;
        }

        public Criteria andByProxyNotBetween(Boolean value1, Boolean value2) {
            addCriterion("BY_PROXY not between", value1, value2, "byProxy");
            return (Criteria) this;
        }

        public Criteria andProxyIpIsNull() {
            addCriterion("PROXY_IP is null");
            return (Criteria) this;
        }

        public Criteria andProxyIpIsNotNull() {
            addCriterion("PROXY_IP is not null");
            return (Criteria) this;
        }

        public Criteria andProxyIpEqualTo(String value) {
            addCriterion("PROXY_IP =", value, "proxyIp");
            return (Criteria) this;
        }

        public Criteria andProxyIpNotEqualTo(String value) {
            addCriterion("PROXY_IP <>", value, "proxyIp");
            return (Criteria) this;
        }

        public Criteria andProxyIpGreaterThan(String value) {
            addCriterion("PROXY_IP >", value, "proxyIp");
            return (Criteria) this;
        }

        public Criteria andProxyIpGreaterThanOrEqualTo(String value) {
            addCriterion("PROXY_IP >=", value, "proxyIp");
            return (Criteria) this;
        }

        public Criteria andProxyIpLessThan(String value) {
            addCriterion("PROXY_IP <", value, "proxyIp");
            return (Criteria) this;
        }

        public Criteria andProxyIpLessThanOrEqualTo(String value) {
            addCriterion("PROXY_IP <=", value, "proxyIp");
            return (Criteria) this;
        }

        public Criteria andProxyIpLike(String value) {
            addCriterion("PROXY_IP like", value, "proxyIp");
            return (Criteria) this;
        }

        public Criteria andProxyIpNotLike(String value) {
            addCriterion("PROXY_IP not like", value, "proxyIp");
            return (Criteria) this;
        }

        public Criteria andProxyIpIn(List<String> values) {
            addCriterion("PROXY_IP in", values, "proxyIp");
            return (Criteria) this;
        }

        public Criteria andProxyIpNotIn(List<String> values) {
            addCriterion("PROXY_IP not in", values, "proxyIp");
            return (Criteria) this;
        }

        public Criteria andProxyIpBetween(String value1, String value2) {
            addCriterion("PROXY_IP between", value1, value2, "proxyIp");
            return (Criteria) this;
        }

        public Criteria andProxyIpNotBetween(String value1, String value2) {
            addCriterion("PROXY_IP not between", value1, value2, "proxyIp");
            return (Criteria) this;
        }

        public Criteria andProxyPortIsNull() {
            addCriterion("PROXY_PORT is null");
            return (Criteria) this;
        }

        public Criteria andProxyPortIsNotNull() {
            addCriterion("PROXY_PORT is not null");
            return (Criteria) this;
        }

        public Criteria andProxyPortEqualTo(Integer value) {
            addCriterion("PROXY_PORT =", value, "proxyPort");
            return (Criteria) this;
        }

        public Criteria andProxyPortNotEqualTo(Integer value) {
            addCriterion("PROXY_PORT <>", value, "proxyPort");
            return (Criteria) this;
        }

        public Criteria andProxyPortGreaterThan(Integer value) {
            addCriterion("PROXY_PORT >", value, "proxyPort");
            return (Criteria) this;
        }

        public Criteria andProxyPortGreaterThanOrEqualTo(Integer value) {
            addCriterion("PROXY_PORT >=", value, "proxyPort");
            return (Criteria) this;
        }

        public Criteria andProxyPortLessThan(Integer value) {
            addCriterion("PROXY_PORT <", value, "proxyPort");
            return (Criteria) this;
        }

        public Criteria andProxyPortLessThanOrEqualTo(Integer value) {
            addCriterion("PROXY_PORT <=", value, "proxyPort");
            return (Criteria) this;
        }

        public Criteria andProxyPortIn(List<Integer> values) {
            addCriterion("PROXY_PORT in", values, "proxyPort");
            return (Criteria) this;
        }

        public Criteria andProxyPortNotIn(List<Integer> values) {
            addCriterion("PROXY_PORT not in", values, "proxyPort");
            return (Criteria) this;
        }

        public Criteria andProxyPortBetween(Integer value1, Integer value2) {
            addCriterion("PROXY_PORT between", value1, value2, "proxyPort");
            return (Criteria) this;
        }

        public Criteria andProxyPortNotBetween(Integer value1, Integer value2) {
            addCriterion("PROXY_PORT not between", value1, value2, "proxyPort");
            return (Criteria) this;
        }

        public Criteria andProxyUsernameIsNull() {
            addCriterion("PROXY_USERNAME is null");
            return (Criteria) this;
        }

        public Criteria andProxyUsernameIsNotNull() {
            addCriterion("PROXY_USERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andProxyUsernameEqualTo(String value) {
            addCriterion("PROXY_USERNAME =", value, "proxyUsername");
            return (Criteria) this;
        }

        public Criteria andProxyUsernameNotEqualTo(String value) {
            addCriterion("PROXY_USERNAME <>", value, "proxyUsername");
            return (Criteria) this;
        }

        public Criteria andProxyUsernameGreaterThan(String value) {
            addCriterion("PROXY_USERNAME >", value, "proxyUsername");
            return (Criteria) this;
        }

        public Criteria andProxyUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("PROXY_USERNAME >=", value, "proxyUsername");
            return (Criteria) this;
        }

        public Criteria andProxyUsernameLessThan(String value) {
            addCriterion("PROXY_USERNAME <", value, "proxyUsername");
            return (Criteria) this;
        }

        public Criteria andProxyUsernameLessThanOrEqualTo(String value) {
            addCriterion("PROXY_USERNAME <=", value, "proxyUsername");
            return (Criteria) this;
        }

        public Criteria andProxyUsernameLike(String value) {
            addCriterion("PROXY_USERNAME like", value, "proxyUsername");
            return (Criteria) this;
        }

        public Criteria andProxyUsernameNotLike(String value) {
            addCriterion("PROXY_USERNAME not like", value, "proxyUsername");
            return (Criteria) this;
        }

        public Criteria andProxyUsernameIn(List<String> values) {
            addCriterion("PROXY_USERNAME in", values, "proxyUsername");
            return (Criteria) this;
        }

        public Criteria andProxyUsernameNotIn(List<String> values) {
            addCriterion("PROXY_USERNAME not in", values, "proxyUsername");
            return (Criteria) this;
        }

        public Criteria andProxyUsernameBetween(String value1, String value2) {
            addCriterion("PROXY_USERNAME between", value1, value2, "proxyUsername");
            return (Criteria) this;
        }

        public Criteria andProxyUsernameNotBetween(String value1, String value2) {
            addCriterion("PROXY_USERNAME not between", value1, value2, "proxyUsername");
            return (Criteria) this;
        }

        public Criteria andProxyPasswordIsNull() {
            addCriterion("PROXY_PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andProxyPasswordIsNotNull() {
            addCriterion("PROXY_PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andProxyPasswordEqualTo(String value) {
            addCriterion("PROXY_PASSWORD =", value, "proxyPassword");
            return (Criteria) this;
        }

        public Criteria andProxyPasswordNotEqualTo(String value) {
            addCriterion("PROXY_PASSWORD <>", value, "proxyPassword");
            return (Criteria) this;
        }

        public Criteria andProxyPasswordGreaterThan(String value) {
            addCriterion("PROXY_PASSWORD >", value, "proxyPassword");
            return (Criteria) this;
        }

        public Criteria andProxyPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("PROXY_PASSWORD >=", value, "proxyPassword");
            return (Criteria) this;
        }

        public Criteria andProxyPasswordLessThan(String value) {
            addCriterion("PROXY_PASSWORD <", value, "proxyPassword");
            return (Criteria) this;
        }

        public Criteria andProxyPasswordLessThanOrEqualTo(String value) {
            addCriterion("PROXY_PASSWORD <=", value, "proxyPassword");
            return (Criteria) this;
        }

        public Criteria andProxyPasswordLike(String value) {
            addCriterion("PROXY_PASSWORD like", value, "proxyPassword");
            return (Criteria) this;
        }

        public Criteria andProxyPasswordNotLike(String value) {
            addCriterion("PROXY_PASSWORD not like", value, "proxyPassword");
            return (Criteria) this;
        }

        public Criteria andProxyPasswordIn(List<String> values) {
            addCriterion("PROXY_PASSWORD in", values, "proxyPassword");
            return (Criteria) this;
        }

        public Criteria andProxyPasswordNotIn(List<String> values) {
            addCriterion("PROXY_PASSWORD not in", values, "proxyPassword");
            return (Criteria) this;
        }

        public Criteria andProxyPasswordBetween(String value1, String value2) {
            addCriterion("PROXY_PASSWORD between", value1, value2, "proxyPassword");
            return (Criteria) this;
        }

        public Criteria andProxyPasswordNotBetween(String value1, String value2) {
            addCriterion("PROXY_PASSWORD not between", value1, value2, "proxyPassword");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("STATE like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("STATE not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("STATE not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andTotalNoticeNumIsNull() {
            addCriterion("TOTAL_NOTICE_NUM is null");
            return (Criteria) this;
        }

        public Criteria andTotalNoticeNumIsNotNull() {
            addCriterion("TOTAL_NOTICE_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andTotalNoticeNumEqualTo(Integer value) {
            addCriterion("TOTAL_NOTICE_NUM =", value, "totalNoticeNum");
            return (Criteria) this;
        }

        public Criteria andTotalNoticeNumNotEqualTo(Integer value) {
            addCriterion("TOTAL_NOTICE_NUM <>", value, "totalNoticeNum");
            return (Criteria) this;
        }

        public Criteria andTotalNoticeNumGreaterThan(Integer value) {
            addCriterion("TOTAL_NOTICE_NUM >", value, "totalNoticeNum");
            return (Criteria) this;
        }

        public Criteria andTotalNoticeNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("TOTAL_NOTICE_NUM >=", value, "totalNoticeNum");
            return (Criteria) this;
        }

        public Criteria andTotalNoticeNumLessThan(Integer value) {
            addCriterion("TOTAL_NOTICE_NUM <", value, "totalNoticeNum");
            return (Criteria) this;
        }

        public Criteria andTotalNoticeNumLessThanOrEqualTo(Integer value) {
            addCriterion("TOTAL_NOTICE_NUM <=", value, "totalNoticeNum");
            return (Criteria) this;
        }

        public Criteria andTotalNoticeNumIn(List<Integer> values) {
            addCriterion("TOTAL_NOTICE_NUM in", values, "totalNoticeNum");
            return (Criteria) this;
        }

        public Criteria andTotalNoticeNumNotIn(List<Integer> values) {
            addCriterion("TOTAL_NOTICE_NUM not in", values, "totalNoticeNum");
            return (Criteria) this;
        }

        public Criteria andTotalNoticeNumBetween(Integer value1, Integer value2) {
            addCriterion("TOTAL_NOTICE_NUM between", value1, value2, "totalNoticeNum");
            return (Criteria) this;
        }

        public Criteria andTotalNoticeNumNotBetween(Integer value1, Integer value2) {
            addCriterion("TOTAL_NOTICE_NUM not between", value1, value2, "totalNoticeNum");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("CREATE_USER is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("CREATE_USER is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("CREATE_USER =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("CREATE_USER <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("CREATE_USER >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_USER >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("CREATE_USER <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("CREATE_USER <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("CREATE_USER like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("CREATE_USER not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("CREATE_USER in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("CREATE_USER not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("CREATE_USER between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("CREATE_USER not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("UPDATE_USER is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("UPDATE_USER is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("UPDATE_USER =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("UPDATE_USER <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("UPDATE_USER >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_USER >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("UPDATE_USER <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_USER <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("UPDATE_USER like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("UPDATE_USER not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("UPDATE_USER in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("UPDATE_USER not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("UPDATE_USER between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("UPDATE_USER not between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andGuidIsNull() {
            addCriterion("GUID is null");
            return (Criteria) this;
        }

        public Criteria andGuidIsNotNull() {
            addCriterion("GUID is not null");
            return (Criteria) this;
        }

        public Criteria andGuidEqualTo(String value) {
            addCriterion("GUID =", value, "guid");
            return (Criteria) this;
        }

        public Criteria andGuidNotEqualTo(String value) {
            addCriterion("GUID <>", value, "guid");
            return (Criteria) this;
        }

        public Criteria andGuidGreaterThan(String value) {
            addCriterion("GUID >", value, "guid");
            return (Criteria) this;
        }

        public Criteria andGuidGreaterThanOrEqualTo(String value) {
            addCriterion("GUID >=", value, "guid");
            return (Criteria) this;
        }

        public Criteria andGuidLessThan(String value) {
            addCriterion("GUID <", value, "guid");
            return (Criteria) this;
        }

        public Criteria andGuidLessThanOrEqualTo(String value) {
            addCriterion("GUID <=", value, "guid");
            return (Criteria) this;
        }

        public Criteria andGuidLike(String value) {
            addCriterion("GUID like", value, "guid");
            return (Criteria) this;
        }

        public Criteria andGuidNotLike(String value) {
            addCriterion("GUID not like", value, "guid");
            return (Criteria) this;
        }

        public Criteria andGuidIn(List<String> values) {
            addCriterion("GUID in", values, "guid");
            return (Criteria) this;
        }

        public Criteria andGuidNotIn(List<String> values) {
            addCriterion("GUID not in", values, "guid");
            return (Criteria) this;
        }

        public Criteria andGuidBetween(String value1, String value2) {
            addCriterion("GUID between", value1, value2, "guid");
            return (Criteria) this;
        }

        public Criteria andGuidNotBetween(String value1, String value2) {
            addCriterion("GUID not between", value1, value2, "guid");
            return (Criteria) this;
        }

        public Criteria andItfIdLikeInsensitive(String value) {
            addCriterion("upper(ITF_ID) like", value.toUpperCase(), "itfId");
            return (Criteria) this;
        }

        public Criteria andTaskGroupIdLikeInsensitive(String value) {
            addCriterion("upper(TASK_GROUP_ID) like", value.toUpperCase(), "taskGroupId");
            return (Criteria) this;
        }

        public Criteria andBelongToLikeInsensitive(String value) {
            addCriterion("upper(BELONG_TO) like", value.toUpperCase(), "belongTo");
            return (Criteria) this;
        }

        public Criteria andItfUrlLikeInsensitive(String value) {
            addCriterion("upper(ITF_URL) like", value.toUpperCase(), "itfUrl");
            return (Criteria) this;
        }

        public Criteria andItfParamsLikeInsensitive(String value) {
            addCriterion("upper(ITF_PARAMS) like", value.toUpperCase(), "itfParams");
            return (Criteria) this;
        }

        public Criteria andRequestMethodLikeInsensitive(String value) {
            addCriterion("upper(REQUEST_METHOD) like", value.toUpperCase(), "requestMethod");
            return (Criteria) this;
        }

        public Criteria andCheckKeyLikeInsensitive(String value) {
            addCriterion("upper(CHECK_KEY) like", value.toUpperCase(), "checkKey");
            return (Criteria) this;
        }

        public Criteria andCheckValueLikeInsensitive(String value) {
            addCriterion("upper(CHECK_VALUE) like", value.toUpperCase(), "checkValue");
            return (Criteria) this;
        }

        public Criteria andNoticeLvlLikeInsensitive(String value) {
            addCriterion("upper(NOTICE_LVL) like", value.toUpperCase(), "noticeLvl");
            return (Criteria) this;
        }

        public Criteria andNoticeObjectLikeInsensitive(String value) {
            addCriterion("upper(NOTICE_OBJECT) like", value.toUpperCase(), "noticeObject");
            return (Criteria) this;
        }

        public Criteria andProxyIpLikeInsensitive(String value) {
            addCriterion("upper(PROXY_IP) like", value.toUpperCase(), "proxyIp");
            return (Criteria) this;
        }

        public Criteria andProxyUsernameLikeInsensitive(String value) {
            addCriterion("upper(PROXY_USERNAME) like", value.toUpperCase(), "proxyUsername");
            return (Criteria) this;
        }

        public Criteria andProxyPasswordLikeInsensitive(String value) {
            addCriterion("upper(PROXY_PASSWORD) like", value.toUpperCase(), "proxyPassword");
            return (Criteria) this;
        }

        public Criteria andStateLikeInsensitive(String value) {
            addCriterion("upper(STATE) like", value.toUpperCase(), "state");
            return (Criteria) this;
        }

        public Criteria andCreateUserLikeInsensitive(String value) {
            addCriterion("upper(CREATE_USER) like", value.toUpperCase(), "createUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLikeInsensitive(String value) {
            addCriterion("upper(UPDATE_USER) like", value.toUpperCase(), "updateUser");
            return (Criteria) this;
        }

        public Criteria andGuidLikeInsensitive(String value) {
            addCriterion("upper(GUID) like", value.toUpperCase(), "guid");
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