package com.jike.system.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DetectDatabaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public DetectDatabaseExample() {
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

        public Criteria andDbDriverIsNull() {
            addCriterion("DB_DRIVER is null");
            return (Criteria) this;
        }

        public Criteria andDbDriverIsNotNull() {
            addCriterion("DB_DRIVER is not null");
            return (Criteria) this;
        }

        public Criteria andDbDriverEqualTo(String value) {
            addCriterion("DB_DRIVER =", value, "dbDriver");
            return (Criteria) this;
        }

        public Criteria andDbDriverNotEqualTo(String value) {
            addCriterion("DB_DRIVER <>", value, "dbDriver");
            return (Criteria) this;
        }

        public Criteria andDbDriverGreaterThan(String value) {
            addCriterion("DB_DRIVER >", value, "dbDriver");
            return (Criteria) this;
        }

        public Criteria andDbDriverGreaterThanOrEqualTo(String value) {
            addCriterion("DB_DRIVER >=", value, "dbDriver");
            return (Criteria) this;
        }

        public Criteria andDbDriverLessThan(String value) {
            addCriterion("DB_DRIVER <", value, "dbDriver");
            return (Criteria) this;
        }

        public Criteria andDbDriverLessThanOrEqualTo(String value) {
            addCriterion("DB_DRIVER <=", value, "dbDriver");
            return (Criteria) this;
        }

        public Criteria andDbDriverLike(String value) {
            addCriterion("DB_DRIVER like", value, "dbDriver");
            return (Criteria) this;
        }

        public Criteria andDbDriverNotLike(String value) {
            addCriterion("DB_DRIVER not like", value, "dbDriver");
            return (Criteria) this;
        }

        public Criteria andDbDriverIn(List<String> values) {
            addCriterion("DB_DRIVER in", values, "dbDriver");
            return (Criteria) this;
        }

        public Criteria andDbDriverNotIn(List<String> values) {
            addCriterion("DB_DRIVER not in", values, "dbDriver");
            return (Criteria) this;
        }

        public Criteria andDbDriverBetween(String value1, String value2) {
            addCriterion("DB_DRIVER between", value1, value2, "dbDriver");
            return (Criteria) this;
        }

        public Criteria andDbDriverNotBetween(String value1, String value2) {
            addCriterion("DB_DRIVER not between", value1, value2, "dbDriver");
            return (Criteria) this;
        }

        public Criteria andDbUrlIsNull() {
            addCriterion("DB_URL is null");
            return (Criteria) this;
        }

        public Criteria andDbUrlIsNotNull() {
            addCriterion("DB_URL is not null");
            return (Criteria) this;
        }

        public Criteria andDbUrlEqualTo(String value) {
            addCriterion("DB_URL =", value, "dbUrl");
            return (Criteria) this;
        }

        public Criteria andDbUrlNotEqualTo(String value) {
            addCriterion("DB_URL <>", value, "dbUrl");
            return (Criteria) this;
        }

        public Criteria andDbUrlGreaterThan(String value) {
            addCriterion("DB_URL >", value, "dbUrl");
            return (Criteria) this;
        }

        public Criteria andDbUrlGreaterThanOrEqualTo(String value) {
            addCriterion("DB_URL >=", value, "dbUrl");
            return (Criteria) this;
        }

        public Criteria andDbUrlLessThan(String value) {
            addCriterion("DB_URL <", value, "dbUrl");
            return (Criteria) this;
        }

        public Criteria andDbUrlLessThanOrEqualTo(String value) {
            addCriterion("DB_URL <=", value, "dbUrl");
            return (Criteria) this;
        }

        public Criteria andDbUrlLike(String value) {
            addCriterion("DB_URL like", value, "dbUrl");
            return (Criteria) this;
        }

        public Criteria andDbUrlNotLike(String value) {
            addCriterion("DB_URL not like", value, "dbUrl");
            return (Criteria) this;
        }

        public Criteria andDbUrlIn(List<String> values) {
            addCriterion("DB_URL in", values, "dbUrl");
            return (Criteria) this;
        }

        public Criteria andDbUrlNotIn(List<String> values) {
            addCriterion("DB_URL not in", values, "dbUrl");
            return (Criteria) this;
        }

        public Criteria andDbUrlBetween(String value1, String value2) {
            addCriterion("DB_URL between", value1, value2, "dbUrl");
            return (Criteria) this;
        }

        public Criteria andDbUrlNotBetween(String value1, String value2) {
            addCriterion("DB_URL not between", value1, value2, "dbUrl");
            return (Criteria) this;
        }

        public Criteria andDbUsernameIsNull() {
            addCriterion("DB_USERNAME is null");
            return (Criteria) this;
        }

        public Criteria andDbUsernameIsNotNull() {
            addCriterion("DB_USERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andDbUsernameEqualTo(String value) {
            addCriterion("DB_USERNAME =", value, "dbUsername");
            return (Criteria) this;
        }

        public Criteria andDbUsernameNotEqualTo(String value) {
            addCriterion("DB_USERNAME <>", value, "dbUsername");
            return (Criteria) this;
        }

        public Criteria andDbUsernameGreaterThan(String value) {
            addCriterion("DB_USERNAME >", value, "dbUsername");
            return (Criteria) this;
        }

        public Criteria andDbUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("DB_USERNAME >=", value, "dbUsername");
            return (Criteria) this;
        }

        public Criteria andDbUsernameLessThan(String value) {
            addCriterion("DB_USERNAME <", value, "dbUsername");
            return (Criteria) this;
        }

        public Criteria andDbUsernameLessThanOrEqualTo(String value) {
            addCriterion("DB_USERNAME <=", value, "dbUsername");
            return (Criteria) this;
        }

        public Criteria andDbUsernameLike(String value) {
            addCriterion("DB_USERNAME like", value, "dbUsername");
            return (Criteria) this;
        }

        public Criteria andDbUsernameNotLike(String value) {
            addCriterion("DB_USERNAME not like", value, "dbUsername");
            return (Criteria) this;
        }

        public Criteria andDbUsernameIn(List<String> values) {
            addCriterion("DB_USERNAME in", values, "dbUsername");
            return (Criteria) this;
        }

        public Criteria andDbUsernameNotIn(List<String> values) {
            addCriterion("DB_USERNAME not in", values, "dbUsername");
            return (Criteria) this;
        }

        public Criteria andDbUsernameBetween(String value1, String value2) {
            addCriterion("DB_USERNAME between", value1, value2, "dbUsername");
            return (Criteria) this;
        }

        public Criteria andDbUsernameNotBetween(String value1, String value2) {
            addCriterion("DB_USERNAME not between", value1, value2, "dbUsername");
            return (Criteria) this;
        }

        public Criteria andDbPasswordIsNull() {
            addCriterion("DB_PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andDbPasswordIsNotNull() {
            addCriterion("DB_PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andDbPasswordEqualTo(String value) {
            addCriterion("DB_PASSWORD =", value, "dbPassword");
            return (Criteria) this;
        }

        public Criteria andDbPasswordNotEqualTo(String value) {
            addCriterion("DB_PASSWORD <>", value, "dbPassword");
            return (Criteria) this;
        }

        public Criteria andDbPasswordGreaterThan(String value) {
            addCriterion("DB_PASSWORD >", value, "dbPassword");
            return (Criteria) this;
        }

        public Criteria andDbPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("DB_PASSWORD >=", value, "dbPassword");
            return (Criteria) this;
        }

        public Criteria andDbPasswordLessThan(String value) {
            addCriterion("DB_PASSWORD <", value, "dbPassword");
            return (Criteria) this;
        }

        public Criteria andDbPasswordLessThanOrEqualTo(String value) {
            addCriterion("DB_PASSWORD <=", value, "dbPassword");
            return (Criteria) this;
        }

        public Criteria andDbPasswordLike(String value) {
            addCriterion("DB_PASSWORD like", value, "dbPassword");
            return (Criteria) this;
        }

        public Criteria andDbPasswordNotLike(String value) {
            addCriterion("DB_PASSWORD not like", value, "dbPassword");
            return (Criteria) this;
        }

        public Criteria andDbPasswordIn(List<String> values) {
            addCriterion("DB_PASSWORD in", values, "dbPassword");
            return (Criteria) this;
        }

        public Criteria andDbPasswordNotIn(List<String> values) {
            addCriterion("DB_PASSWORD not in", values, "dbPassword");
            return (Criteria) this;
        }

        public Criteria andDbPasswordBetween(String value1, String value2) {
            addCriterion("DB_PASSWORD between", value1, value2, "dbPassword");
            return (Criteria) this;
        }

        public Criteria andDbPasswordNotBetween(String value1, String value2) {
            addCriterion("DB_PASSWORD not between", value1, value2, "dbPassword");
            return (Criteria) this;
        }

        public Criteria andCronExpressionIsNull() {
            addCriterion("CRON_EXPRESSION is null");
            return (Criteria) this;
        }

        public Criteria andCronExpressionIsNotNull() {
            addCriterion("CRON_EXPRESSION is not null");
            return (Criteria) this;
        }

        public Criteria andCronExpressionEqualTo(String value) {
            addCriterion("CRON_EXPRESSION =", value, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionNotEqualTo(String value) {
            addCriterion("CRON_EXPRESSION <>", value, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionGreaterThan(String value) {
            addCriterion("CRON_EXPRESSION >", value, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionGreaterThanOrEqualTo(String value) {
            addCriterion("CRON_EXPRESSION >=", value, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionLessThan(String value) {
            addCriterion("CRON_EXPRESSION <", value, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionLessThanOrEqualTo(String value) {
            addCriterion("CRON_EXPRESSION <=", value, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionLike(String value) {
            addCriterion("CRON_EXPRESSION like", value, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionNotLike(String value) {
            addCriterion("CRON_EXPRESSION not like", value, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionIn(List<String> values) {
            addCriterion("CRON_EXPRESSION in", values, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionNotIn(List<String> values) {
            addCriterion("CRON_EXPRESSION not in", values, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionBetween(String value1, String value2) {
            addCriterion("CRON_EXPRESSION between", value1, value2, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionNotBetween(String value1, String value2) {
            addCriterion("CRON_EXPRESSION not between", value1, value2, "cronExpression");
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

        public Criteria andThresholdValueEqualTo(Integer value) {
            addCriterion("THRESHOLD_VALUE =", value, "thresholdValue");
            return (Criteria) this;
        }

        public Criteria andThresholdValueNotEqualTo(Integer value) {
            addCriterion("THRESHOLD_VALUE <>", value, "thresholdValue");
            return (Criteria) this;
        }

        public Criteria andThresholdValueGreaterThan(Integer value) {
            addCriterion("THRESHOLD_VALUE >", value, "thresholdValue");
            return (Criteria) this;
        }

        public Criteria andThresholdValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("THRESHOLD_VALUE >=", value, "thresholdValue");
            return (Criteria) this;
        }

        public Criteria andThresholdValueLessThan(Integer value) {
            addCriterion("THRESHOLD_VALUE <", value, "thresholdValue");
            return (Criteria) this;
        }

        public Criteria andThresholdValueLessThanOrEqualTo(Integer value) {
            addCriterion("THRESHOLD_VALUE <=", value, "thresholdValue");
            return (Criteria) this;
        }

        public Criteria andThresholdValueIn(List<Integer> values) {
            addCriterion("THRESHOLD_VALUE in", values, "thresholdValue");
            return (Criteria) this;
        }

        public Criteria andThresholdValueNotIn(List<Integer> values) {
            addCriterion("THRESHOLD_VALUE not in", values, "thresholdValue");
            return (Criteria) this;
        }

        public Criteria andThresholdValueBetween(Integer value1, Integer value2) {
            addCriterion("THRESHOLD_VALUE between", value1, value2, "thresholdValue");
            return (Criteria) this;
        }

        public Criteria andThresholdValueNotBetween(Integer value1, Integer value2) {
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

        public Criteria andCurrentFailureNumEqualTo(Integer value) {
            addCriterion("CURRENT_FAILURE_NUM =", value, "currentFailureNum");
            return (Criteria) this;
        }

        public Criteria andCurrentFailureNumNotEqualTo(Integer value) {
            addCriterion("CURRENT_FAILURE_NUM <>", value, "currentFailureNum");
            return (Criteria) this;
        }

        public Criteria andCurrentFailureNumGreaterThan(Integer value) {
            addCriterion("CURRENT_FAILURE_NUM >", value, "currentFailureNum");
            return (Criteria) this;
        }

        public Criteria andCurrentFailureNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("CURRENT_FAILURE_NUM >=", value, "currentFailureNum");
            return (Criteria) this;
        }

        public Criteria andCurrentFailureNumLessThan(Integer value) {
            addCriterion("CURRENT_FAILURE_NUM <", value, "currentFailureNum");
            return (Criteria) this;
        }

        public Criteria andCurrentFailureNumLessThanOrEqualTo(Integer value) {
            addCriterion("CURRENT_FAILURE_NUM <=", value, "currentFailureNum");
            return (Criteria) this;
        }

        public Criteria andCurrentFailureNumIn(List<Integer> values) {
            addCriterion("CURRENT_FAILURE_NUM in", values, "currentFailureNum");
            return (Criteria) this;
        }

        public Criteria andCurrentFailureNumNotIn(List<Integer> values) {
            addCriterion("CURRENT_FAILURE_NUM not in", values, "currentFailureNum");
            return (Criteria) this;
        }

        public Criteria andCurrentFailureNumBetween(Integer value1, Integer value2) {
            addCriterion("CURRENT_FAILURE_NUM between", value1, value2, "currentFailureNum");
            return (Criteria) this;
        }

        public Criteria andCurrentFailureNumNotBetween(Integer value1, Integer value2) {
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

        public Criteria andTaskIdLikeInsensitive(String value) {
            addCriterion("upper(TASK_ID) like", value.toUpperCase(), "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskGroupIdLikeInsensitive(String value) {
            addCriterion("upper(TASK_GROUP_ID) like", value.toUpperCase(), "taskGroupId");
            return (Criteria) this;
        }

        public Criteria andDbDriverLikeInsensitive(String value) {
            addCriterion("upper(DB_DRIVER) like", value.toUpperCase(), "dbDriver");
            return (Criteria) this;
        }

        public Criteria andDbUrlLikeInsensitive(String value) {
            addCriterion("upper(DB_URL) like", value.toUpperCase(), "dbUrl");
            return (Criteria) this;
        }

        public Criteria andDbUsernameLikeInsensitive(String value) {
            addCriterion("upper(DB_USERNAME) like", value.toUpperCase(), "dbUsername");
            return (Criteria) this;
        }

        public Criteria andDbPasswordLikeInsensitive(String value) {
            addCriterion("upper(DB_PASSWORD) like", value.toUpperCase(), "dbPassword");
            return (Criteria) this;
        }

        public Criteria andCronExpressionLikeInsensitive(String value) {
            addCriterion("upper(CRON_EXPRESSION) like", value.toUpperCase(), "cronExpression");
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