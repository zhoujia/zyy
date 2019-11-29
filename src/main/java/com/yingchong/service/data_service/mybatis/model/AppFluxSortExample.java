package com.yingchong.service.data_service.mybatis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppFluxSortExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppFluxSortExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAppNameIsNull() {
            addCriterion("app_name is null");
            return (Criteria) this;
        }

        public Criteria andAppNameIsNotNull() {
            addCriterion("app_name is not null");
            return (Criteria) this;
        }

        public Criteria andAppNameEqualTo(String value) {
            addCriterion("app_name =", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotEqualTo(String value) {
            addCriterion("app_name <>", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameGreaterThan(String value) {
            addCriterion("app_name >", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameGreaterThanOrEqualTo(String value) {
            addCriterion("app_name >=", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLessThan(String value) {
            addCriterion("app_name <", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLessThanOrEqualTo(String value) {
            addCriterion("app_name <=", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLike(String value) {
            addCriterion("app_name like", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotLike(String value) {
            addCriterion("app_name not like", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameIn(List<String> values) {
            addCriterion("app_name in", values, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotIn(List<String> values) {
            addCriterion("app_name not in", values, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameBetween(String value1, String value2) {
            addCriterion("app_name between", value1, value2, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotBetween(String value1, String value2) {
            addCriterion("app_name not between", value1, value2, "appName");
            return (Criteria) this;
        }

        public Criteria andFluxIsNull() {
            addCriterion("flux is null");
            return (Criteria) this;
        }

        public Criteria andFluxIsNotNull() {
            addCriterion("flux is not null");
            return (Criteria) this;
        }

        public Criteria andFluxEqualTo(Double value) {
            addCriterion("flux =", value, "flux");
            return (Criteria) this;
        }

        public Criteria andFluxNotEqualTo(Double value) {
            addCriterion("flux <>", value, "flux");
            return (Criteria) this;
        }

        public Criteria andFluxGreaterThan(Double value) {
            addCriterion("flux >", value, "flux");
            return (Criteria) this;
        }

        public Criteria andFluxGreaterThanOrEqualTo(Double value) {
            addCriterion("flux >=", value, "flux");
            return (Criteria) this;
        }

        public Criteria andFluxLessThan(Double value) {
            addCriterion("flux <", value, "flux");
            return (Criteria) this;
        }

        public Criteria andFluxLessThanOrEqualTo(Double value) {
            addCriterion("flux <=", value, "flux");
            return (Criteria) this;
        }

        public Criteria andFluxIn(List<Double> values) {
            addCriterion("flux in", values, "flux");
            return (Criteria) this;
        }

        public Criteria andFluxNotIn(List<Double> values) {
            addCriterion("flux not in", values, "flux");
            return (Criteria) this;
        }

        public Criteria andFluxBetween(Double value1, Double value2) {
            addCriterion("flux between", value1, value2, "flux");
            return (Criteria) this;
        }

        public Criteria andFluxNotBetween(Double value1, Double value2) {
            addCriterion("flux not between", value1, value2, "flux");
            return (Criteria) this;
        }

        public Criteria andFluxPercentageIsNull() {
            addCriterion("flux_percentage is null");
            return (Criteria) this;
        }

        public Criteria andFluxPercentageIsNotNull() {
            addCriterion("flux_percentage is not null");
            return (Criteria) this;
        }

        public Criteria andFluxPercentageEqualTo(String value) {
            addCriterion("flux_percentage =", value, "fluxPercentage");
            return (Criteria) this;
        }

        public Criteria andFluxPercentageNotEqualTo(String value) {
            addCriterion("flux_percentage <>", value, "fluxPercentage");
            return (Criteria) this;
        }

        public Criteria andFluxPercentageGreaterThan(String value) {
            addCriterion("flux_percentage >", value, "fluxPercentage");
            return (Criteria) this;
        }

        public Criteria andFluxPercentageGreaterThanOrEqualTo(String value) {
            addCriterion("flux_percentage >=", value, "fluxPercentage");
            return (Criteria) this;
        }

        public Criteria andFluxPercentageLessThan(String value) {
            addCriterion("flux_percentage <", value, "fluxPercentage");
            return (Criteria) this;
        }

        public Criteria andFluxPercentageLessThanOrEqualTo(String value) {
            addCriterion("flux_percentage <=", value, "fluxPercentage");
            return (Criteria) this;
        }

        public Criteria andFluxPercentageLike(String value) {
            addCriterion("flux_percentage like", value, "fluxPercentage");
            return (Criteria) this;
        }

        public Criteria andFluxPercentageNotLike(String value) {
            addCriterion("flux_percentage not like", value, "fluxPercentage");
            return (Criteria) this;
        }

        public Criteria andFluxPercentageIn(List<String> values) {
            addCriterion("flux_percentage in", values, "fluxPercentage");
            return (Criteria) this;
        }

        public Criteria andFluxPercentageNotIn(List<String> values) {
            addCriterion("flux_percentage not in", values, "fluxPercentage");
            return (Criteria) this;
        }

        public Criteria andFluxPercentageBetween(String value1, String value2) {
            addCriterion("flux_percentage between", value1, value2, "fluxPercentage");
            return (Criteria) this;
        }

        public Criteria andFluxPercentageNotBetween(String value1, String value2) {
            addCriterion("flux_percentage not between", value1, value2, "fluxPercentage");
            return (Criteria) this;
        }

        public Criteria andFluxDateIsNull() {
            addCriterion("flux_date is null");
            return (Criteria) this;
        }

        public Criteria andFluxDateIsNotNull() {
            addCriterion("flux_date is not null");
            return (Criteria) this;
        }

        public Criteria andFluxDateEqualTo(String value) {
            addCriterion("flux_date =", value, "fluxDate");
            return (Criteria) this;
        }

        public Criteria andFluxDateNotEqualTo(String value) {
            addCriterion("flux_date <>", value, "fluxDate");
            return (Criteria) this;
        }

        public Criteria andFluxDateGreaterThan(String value) {
            addCriterion("flux_date >", value, "fluxDate");
            return (Criteria) this;
        }

        public Criteria andFluxDateGreaterThanOrEqualTo(String value) {
            addCriterion("flux_date >=", value, "fluxDate");
            return (Criteria) this;
        }

        public Criteria andFluxDateLessThan(String value) {
            addCriterion("flux_date <", value, "fluxDate");
            return (Criteria) this;
        }

        public Criteria andFluxDateLessThanOrEqualTo(String value) {
            addCriterion("flux_date <=", value, "fluxDate");
            return (Criteria) this;
        }

        public Criteria andFluxDateLike(String value) {
            addCriterion("flux_date like", value, "fluxDate");
            return (Criteria) this;
        }

        public Criteria andFluxDateNotLike(String value) {
            addCriterion("flux_date not like", value, "fluxDate");
            return (Criteria) this;
        }

        public Criteria andFluxDateIn(List<String> values) {
            addCriterion("flux_date in", values, "fluxDate");
            return (Criteria) this;
        }

        public Criteria andFluxDateNotIn(List<String> values) {
            addCriterion("flux_date not in", values, "fluxDate");
            return (Criteria) this;
        }

        public Criteria andFluxDateBetween(String value1, String value2) {
            addCriterion("flux_date between", value1, value2, "fluxDate");
            return (Criteria) this;
        }

        public Criteria andFluxDateNotBetween(String value1, String value2) {
            addCriterion("flux_date not between", value1, value2, "fluxDate");
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

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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