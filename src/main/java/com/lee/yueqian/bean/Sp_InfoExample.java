package com.lee.yueqian.bean;

import java.util.ArrayList;
import java.util.List;

public class Sp_InfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Sp_InfoExample() {
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

        public Criteria andSpTypeIsNull() {
            addCriterion("sp_type is null");
            return (Criteria) this;
        }

        public Criteria andSpTypeIsNotNull() {
            addCriterion("sp_type is not null");
            return (Criteria) this;
        }

        public Criteria andSpTypeEqualTo(Integer value) {
            addCriterion("sp_type =", value, "spType");
            return (Criteria) this;
        }

        public Criteria andSpTypeNotEqualTo(Integer value) {
            addCriterion("sp_type <>", value, "spType");
            return (Criteria) this;
        }

        public Criteria andSpTypeGreaterThan(Integer value) {
            addCriterion("sp_type >", value, "spType");
            return (Criteria) this;
        }

        public Criteria andSpTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("sp_type >=", value, "spType");
            return (Criteria) this;
        }

        public Criteria andSpTypeLessThan(Integer value) {
            addCriterion("sp_type <", value, "spType");
            return (Criteria) this;
        }

        public Criteria andSpTypeLessThanOrEqualTo(Integer value) {
            addCriterion("sp_type <=", value, "spType");
            return (Criteria) this;
        }

        public Criteria andSpTypeIn(List<Integer> values) {
            addCriterion("sp_type in", values, "spType");
            return (Criteria) this;
        }

        public Criteria andSpTypeNotIn(List<Integer> values) {
            addCriterion("sp_type not in", values, "spType");
            return (Criteria) this;
        }

        public Criteria andSpTypeBetween(Integer value1, Integer value2) {
            addCriterion("sp_type between", value1, value2, "spType");
            return (Criteria) this;
        }

        public Criteria andSpTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("sp_type not between", value1, value2, "spType");
            return (Criteria) this;
        }

        public Criteria andSpNameIsNull() {
            addCriterion("sp_name is null");
            return (Criteria) this;
        }

        public Criteria andSpNameIsNotNull() {
            addCriterion("sp_name is not null");
            return (Criteria) this;
        }

        public Criteria andSpNameEqualTo(String value) {
            addCriterion("sp_name =", value, "spName");
            return (Criteria) this;
        }

        public Criteria andSpNameNotEqualTo(String value) {
            addCriterion("sp_name <>", value, "spName");
            return (Criteria) this;
        }

        public Criteria andSpNameGreaterThan(String value) {
            addCriterion("sp_name >", value, "spName");
            return (Criteria) this;
        }

        public Criteria andSpNameGreaterThanOrEqualTo(String value) {
            addCriterion("sp_name >=", value, "spName");
            return (Criteria) this;
        }

        public Criteria andSpNameLessThan(String value) {
            addCriterion("sp_name <", value, "spName");
            return (Criteria) this;
        }

        public Criteria andSpNameLessThanOrEqualTo(String value) {
            addCriterion("sp_name <=", value, "spName");
            return (Criteria) this;
        }

        public Criteria andSpNameLike(String value) {
            addCriterion("sp_name like", value, "spName");
            return (Criteria) this;
        }

        public Criteria andSpNameNotLike(String value) {
            addCriterion("sp_name not like", value, "spName");
            return (Criteria) this;
        }

        public Criteria andSpNameIn(List<String> values) {
            addCriterion("sp_name in", values, "spName");
            return (Criteria) this;
        }

        public Criteria andSpNameNotIn(List<String> values) {
            addCriterion("sp_name not in", values, "spName");
            return (Criteria) this;
        }

        public Criteria andSpNameBetween(String value1, String value2) {
            addCriterion("sp_name between", value1, value2, "spName");
            return (Criteria) this;
        }

        public Criteria andSpNameNotBetween(String value1, String value2) {
            addCriterion("sp_name not between", value1, value2, "spName");
            return (Criteria) this;
        }

        public Criteria andOldPriceIsNull() {
            addCriterion("old_price is null");
            return (Criteria) this;
        }

        public Criteria andOldPriceIsNotNull() {
            addCriterion("old_price is not null");
            return (Criteria) this;
        }

        public Criteria andOldPriceEqualTo(String value) {
            addCriterion("old_price =", value, "oldPrice");
            return (Criteria) this;
        }

        public Criteria andOldPriceNotEqualTo(String value) {
            addCriterion("old_price <>", value, "oldPrice");
            return (Criteria) this;
        }

        public Criteria andOldPriceGreaterThan(String value) {
            addCriterion("old_price >", value, "oldPrice");
            return (Criteria) this;
        }

        public Criteria andOldPriceGreaterThanOrEqualTo(String value) {
            addCriterion("old_price >=", value, "oldPrice");
            return (Criteria) this;
        }

        public Criteria andOldPriceLessThan(String value) {
            addCriterion("old_price <", value, "oldPrice");
            return (Criteria) this;
        }

        public Criteria andOldPriceLessThanOrEqualTo(String value) {
            addCriterion("old_price <=", value, "oldPrice");
            return (Criteria) this;
        }

        public Criteria andOldPriceLike(String value) {
            addCriterion("old_price like", value, "oldPrice");
            return (Criteria) this;
        }

        public Criteria andOldPriceNotLike(String value) {
            addCriterion("old_price not like", value, "oldPrice");
            return (Criteria) this;
        }

        public Criteria andOldPriceIn(List<String> values) {
            addCriterion("old_price in", values, "oldPrice");
            return (Criteria) this;
        }

        public Criteria andOldPriceNotIn(List<String> values) {
            addCriterion("old_price not in", values, "oldPrice");
            return (Criteria) this;
        }

        public Criteria andOldPriceBetween(String value1, String value2) {
            addCriterion("old_price between", value1, value2, "oldPrice");
            return (Criteria) this;
        }

        public Criteria andOldPriceNotBetween(String value1, String value2) {
            addCriterion("old_price not between", value1, value2, "oldPrice");
            return (Criteria) this;
        }

        public Criteria andNewPriceIsNull() {
            addCriterion("new_price is null");
            return (Criteria) this;
        }

        public Criteria andNewPriceIsNotNull() {
            addCriterion("new_price is not null");
            return (Criteria) this;
        }

        public Criteria andNewPriceEqualTo(String value) {
            addCriterion("new_price =", value, "newPrice");
            return (Criteria) this;
        }

        public Criteria andNewPriceNotEqualTo(String value) {
            addCriterion("new_price <>", value, "newPrice");
            return (Criteria) this;
        }

        public Criteria andNewPriceGreaterThan(String value) {
            addCriterion("new_price >", value, "newPrice");
            return (Criteria) this;
        }

        public Criteria andNewPriceGreaterThanOrEqualTo(String value) {
            addCriterion("new_price >=", value, "newPrice");
            return (Criteria) this;
        }

        public Criteria andNewPriceLessThan(String value) {
            addCriterion("new_price <", value, "newPrice");
            return (Criteria) this;
        }

        public Criteria andNewPriceLessThanOrEqualTo(String value) {
            addCriterion("new_price <=", value, "newPrice");
            return (Criteria) this;
        }

        public Criteria andNewPriceLike(String value) {
            addCriterion("new_price like", value, "newPrice");
            return (Criteria) this;
        }

        public Criteria andNewPriceNotLike(String value) {
            addCriterion("new_price not like", value, "newPrice");
            return (Criteria) this;
        }

        public Criteria andNewPriceIn(List<String> values) {
            addCriterion("new_price in", values, "newPrice");
            return (Criteria) this;
        }

        public Criteria andNewPriceNotIn(List<String> values) {
            addCriterion("new_price not in", values, "newPrice");
            return (Criteria) this;
        }

        public Criteria andNewPriceBetween(String value1, String value2) {
            addCriterion("new_price between", value1, value2, "newPrice");
            return (Criteria) this;
        }

        public Criteria andNewPriceNotBetween(String value1, String value2) {
            addCriterion("new_price not between", value1, value2, "newPrice");
            return (Criteria) this;
        }

        public Criteria andSpInfoIsNull() {
            addCriterion("sp_info is null");
            return (Criteria) this;
        }

        public Criteria andSpInfoIsNotNull() {
            addCriterion("sp_info is not null");
            return (Criteria) this;
        }

        public Criteria andSpInfoEqualTo(String value) {
            addCriterion("sp_info =", value, "spInfo");
            return (Criteria) this;
        }

        public Criteria andSpInfoNotEqualTo(String value) {
            addCriterion("sp_info <>", value, "spInfo");
            return (Criteria) this;
        }

        public Criteria andSpInfoGreaterThan(String value) {
            addCriterion("sp_info >", value, "spInfo");
            return (Criteria) this;
        }

        public Criteria andSpInfoGreaterThanOrEqualTo(String value) {
            addCriterion("sp_info >=", value, "spInfo");
            return (Criteria) this;
        }

        public Criteria andSpInfoLessThan(String value) {
            addCriterion("sp_info <", value, "spInfo");
            return (Criteria) this;
        }

        public Criteria andSpInfoLessThanOrEqualTo(String value) {
            addCriterion("sp_info <=", value, "spInfo");
            return (Criteria) this;
        }

        public Criteria andSpInfoLike(String value) {
            addCriterion("sp_info like", value, "spInfo");
            return (Criteria) this;
        }

        public Criteria andSpInfoNotLike(String value) {
            addCriterion("sp_info not like", value, "spInfo");
            return (Criteria) this;
        }

        public Criteria andSpInfoIn(List<String> values) {
            addCriterion("sp_info in", values, "spInfo");
            return (Criteria) this;
        }

        public Criteria andSpInfoNotIn(List<String> values) {
            addCriterion("sp_info not in", values, "spInfo");
            return (Criteria) this;
        }

        public Criteria andSpInfoBetween(String value1, String value2) {
            addCriterion("sp_info between", value1, value2, "spInfo");
            return (Criteria) this;
        }

        public Criteria andSpInfoNotBetween(String value1, String value2) {
            addCriterion("sp_info not between", value1, value2, "spInfo");
            return (Criteria) this;
        }

        public Criteria andSpImgIsNull() {
            addCriterion("sp_img is null");
            return (Criteria) this;
        }

        public Criteria andSpImgIsNotNull() {
            addCriterion("sp_img is not null");
            return (Criteria) this;
        }

        public Criteria andSpImgEqualTo(String value) {
            addCriterion("sp_img =", value, "spImg");
            return (Criteria) this;
        }

        public Criteria andSpImgNotEqualTo(String value) {
            addCriterion("sp_img <>", value, "spImg");
            return (Criteria) this;
        }

        public Criteria andSpImgGreaterThan(String value) {
            addCriterion("sp_img >", value, "spImg");
            return (Criteria) this;
        }

        public Criteria andSpImgGreaterThanOrEqualTo(String value) {
            addCriterion("sp_img >=", value, "spImg");
            return (Criteria) this;
        }

        public Criteria andSpImgLessThan(String value) {
            addCriterion("sp_img <", value, "spImg");
            return (Criteria) this;
        }

        public Criteria andSpImgLessThanOrEqualTo(String value) {
            addCriterion("sp_img <=", value, "spImg");
            return (Criteria) this;
        }

        public Criteria andSpImgLike(String value) {
            addCriterion("sp_img like", value, "spImg");
            return (Criteria) this;
        }

        public Criteria andSpImgNotLike(String value) {
            addCriterion("sp_img not like", value, "spImg");
            return (Criteria) this;
        }

        public Criteria andSpImgIn(List<String> values) {
            addCriterion("sp_img in", values, "spImg");
            return (Criteria) this;
        }

        public Criteria andSpImgNotIn(List<String> values) {
            addCriterion("sp_img not in", values, "spImg");
            return (Criteria) this;
        }

        public Criteria andSpImgBetween(String value1, String value2) {
            addCriterion("sp_img between", value1, value2, "spImg");
            return (Criteria) this;
        }

        public Criteria andSpImgNotBetween(String value1, String value2) {
            addCriterion("sp_img not between", value1, value2, "spImg");
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