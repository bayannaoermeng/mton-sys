package com.marathon.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Mrton3PartyStaffExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public Mrton3PartyStaffExample() {
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

    public void setLimitStart(int limitStart) {
        this.limitStart=limitStart;
    }

    public int getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(int limitEnd) {
        this.limitEnd=limitEnd;
    }

    public int getLimitEnd() {
        return limitEnd;
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

        public Criteria andProcIdIsNull() {
            addCriterion("proc_id is null");
            return (Criteria) this;
        }

        public Criteria andProcIdIsNotNull() {
            addCriterion("proc_id is not null");
            return (Criteria) this;
        }

        public Criteria andProcIdEqualTo(String value) {
            addCriterion("proc_id =", value, "procId");
            return (Criteria) this;
        }

        public Criteria andProcIdNotEqualTo(String value) {
            addCriterion("proc_id <>", value, "procId");
            return (Criteria) this;
        }

        public Criteria andProcIdGreaterThan(String value) {
            addCriterion("proc_id >", value, "procId");
            return (Criteria) this;
        }

        public Criteria andProcIdGreaterThanOrEqualTo(String value) {
            addCriterion("proc_id >=", value, "procId");
            return (Criteria) this;
        }

        public Criteria andProcIdLessThan(String value) {
            addCriterion("proc_id <", value, "procId");
            return (Criteria) this;
        }

        public Criteria andProcIdLessThanOrEqualTo(String value) {
            addCriterion("proc_id <=", value, "procId");
            return (Criteria) this;
        }

        public Criteria andProcIdLike(String value) {
            addCriterion("proc_id like", value, "procId");
            return (Criteria) this;
        }

        public Criteria andProcIdNotLike(String value) {
            addCriterion("proc_id not like", value, "procId");
            return (Criteria) this;
        }

        public Criteria andProcIdIn(List<String> values) {
            addCriterion("proc_id in", values, "procId");
            return (Criteria) this;
        }

        public Criteria andProcIdNotIn(List<String> values) {
            addCriterion("proc_id not in", values, "procId");
            return (Criteria) this;
        }

        public Criteria andProcIdBetween(String value1, String value2) {
            addCriterion("proc_id between", value1, value2, "procId");
            return (Criteria) this;
        }

        public Criteria andProcIdNotBetween(String value1, String value2) {
            addCriterion("proc_id not between", value1, value2, "procId");
            return (Criteria) this;
        }

        public Criteria andMasterIsNull() {
            addCriterion("master is null");
            return (Criteria) this;
        }

        public Criteria andMasterIsNotNull() {
            addCriterion("master is not null");
            return (Criteria) this;
        }

        public Criteria andMasterEqualTo(Integer value) {
            addCriterion("master =", value, "master");
            return (Criteria) this;
        }

        public Criteria andMasterNotEqualTo(Integer value) {
            addCriterion("master <>", value, "master");
            return (Criteria) this;
        }

        public Criteria andMasterGreaterThan(Integer value) {
            addCriterion("master >", value, "master");
            return (Criteria) this;
        }

        public Criteria andMasterGreaterThanOrEqualTo(Integer value) {
            addCriterion("master >=", value, "master");
            return (Criteria) this;
        }

        public Criteria andMasterLessThan(Integer value) {
            addCriterion("master <", value, "master");
            return (Criteria) this;
        }

        public Criteria andMasterLessThanOrEqualTo(Integer value) {
            addCriterion("master <=", value, "master");
            return (Criteria) this;
        }

        public Criteria andMasterIn(List<Integer> values) {
            addCriterion("master in", values, "master");
            return (Criteria) this;
        }

        public Criteria andMasterNotIn(List<Integer> values) {
            addCriterion("master not in", values, "master");
            return (Criteria) this;
        }

        public Criteria andMasterBetween(Integer value1, Integer value2) {
            addCriterion("master between", value1, value2, "master");
            return (Criteria) this;
        }

        public Criteria andMasterNotBetween(Integer value1, Integer value2) {
            addCriterion("master not between", value1, value2, "master");
            return (Criteria) this;
        }

        public Criteria andSupplierIsNull() {
            addCriterion("supplier is null");
            return (Criteria) this;
        }

        public Criteria andSupplierIsNotNull() {
            addCriterion("supplier is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierEqualTo(String value) {
            addCriterion("supplier =", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotEqualTo(String value) {
            addCriterion("supplier <>", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierGreaterThan(String value) {
            addCriterion("supplier >", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierGreaterThanOrEqualTo(String value) {
            addCriterion("supplier >=", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierLessThan(String value) {
            addCriterion("supplier <", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierLessThanOrEqualTo(String value) {
            addCriterion("supplier <=", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierLike(String value) {
            addCriterion("supplier like", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotLike(String value) {
            addCriterion("supplier not like", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierIn(List<String> values) {
            addCriterion("supplier in", values, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotIn(List<String> values) {
            addCriterion("supplier not in", values, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierBetween(String value1, String value2) {
            addCriterion("supplier between", value1, value2, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotBetween(String value1, String value2) {
            addCriterion("supplier not between", value1, value2, "supplier");
            return (Criteria) this;
        }

        public Criteria andContactPersonIsNull() {
            addCriterion("contact_person is null");
            return (Criteria) this;
        }

        public Criteria andContactPersonIsNotNull() {
            addCriterion("contact_person is not null");
            return (Criteria) this;
        }

        public Criteria andContactPersonEqualTo(String value) {
            addCriterion("contact_person =", value, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonNotEqualTo(String value) {
            addCriterion("contact_person <>", value, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonGreaterThan(String value) {
            addCriterion("contact_person >", value, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonGreaterThanOrEqualTo(String value) {
            addCriterion("contact_person >=", value, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonLessThan(String value) {
            addCriterion("contact_person <", value, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonLessThanOrEqualTo(String value) {
            addCriterion("contact_person <=", value, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonLike(String value) {
            addCriterion("contact_person like", value, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonNotLike(String value) {
            addCriterion("contact_person not like", value, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonIn(List<String> values) {
            addCriterion("contact_person in", values, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonNotIn(List<String> values) {
            addCriterion("contact_person not in", values, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonBetween(String value1, String value2) {
            addCriterion("contact_person between", value1, value2, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonNotBetween(String value1, String value2) {
            addCriterion("contact_person not between", value1, value2, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(String value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(String value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(String value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(String value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(String value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(String value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLike(String value) {
            addCriterion("price like", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotLike(String value) {
            addCriterion("price not like", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<String> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<String> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(String value1, String value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(String value1, String value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andTransportationIsNull() {
            addCriterion("transportation is null");
            return (Criteria) this;
        }

        public Criteria andTransportationIsNotNull() {
            addCriterion("transportation is not null");
            return (Criteria) this;
        }

        public Criteria andTransportationEqualTo(String value) {
            addCriterion("transportation =", value, "transportation");
            return (Criteria) this;
        }

        public Criteria andTransportationNotEqualTo(String value) {
            addCriterion("transportation <>", value, "transportation");
            return (Criteria) this;
        }

        public Criteria andTransportationGreaterThan(String value) {
            addCriterion("transportation >", value, "transportation");
            return (Criteria) this;
        }

        public Criteria andTransportationGreaterThanOrEqualTo(String value) {
            addCriterion("transportation >=", value, "transportation");
            return (Criteria) this;
        }

        public Criteria andTransportationLessThan(String value) {
            addCriterion("transportation <", value, "transportation");
            return (Criteria) this;
        }

        public Criteria andTransportationLessThanOrEqualTo(String value) {
            addCriterion("transportation <=", value, "transportation");
            return (Criteria) this;
        }

        public Criteria andTransportationLike(String value) {
            addCriterion("transportation like", value, "transportation");
            return (Criteria) this;
        }

        public Criteria andTransportationNotLike(String value) {
            addCriterion("transportation not like", value, "transportation");
            return (Criteria) this;
        }

        public Criteria andTransportationIn(List<String> values) {
            addCriterion("transportation in", values, "transportation");
            return (Criteria) this;
        }

        public Criteria andTransportationNotIn(List<String> values) {
            addCriterion("transportation not in", values, "transportation");
            return (Criteria) this;
        }

        public Criteria andTransportationBetween(String value1, String value2) {
            addCriterion("transportation between", value1, value2, "transportation");
            return (Criteria) this;
        }

        public Criteria andTransportationNotBetween(String value1, String value2) {
            addCriterion("transportation not between", value1, value2, "transportation");
            return (Criteria) this;
        }

        public Criteria andInvoiceDetailIsNull() {
            addCriterion("invoice_detail is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceDetailIsNotNull() {
            addCriterion("invoice_detail is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceDetailEqualTo(String value) {
            addCriterion("invoice_detail =", value, "invoiceDetail");
            return (Criteria) this;
        }

        public Criteria andInvoiceDetailNotEqualTo(String value) {
            addCriterion("invoice_detail <>", value, "invoiceDetail");
            return (Criteria) this;
        }

        public Criteria andInvoiceDetailGreaterThan(String value) {
            addCriterion("invoice_detail >", value, "invoiceDetail");
            return (Criteria) this;
        }

        public Criteria andInvoiceDetailGreaterThanOrEqualTo(String value) {
            addCriterion("invoice_detail >=", value, "invoiceDetail");
            return (Criteria) this;
        }

        public Criteria andInvoiceDetailLessThan(String value) {
            addCriterion("invoice_detail <", value, "invoiceDetail");
            return (Criteria) this;
        }

        public Criteria andInvoiceDetailLessThanOrEqualTo(String value) {
            addCriterion("invoice_detail <=", value, "invoiceDetail");
            return (Criteria) this;
        }

        public Criteria andInvoiceDetailLike(String value) {
            addCriterion("invoice_detail like", value, "invoiceDetail");
            return (Criteria) this;
        }

        public Criteria andInvoiceDetailNotLike(String value) {
            addCriterion("invoice_detail not like", value, "invoiceDetail");
            return (Criteria) this;
        }

        public Criteria andInvoiceDetailIn(List<String> values) {
            addCriterion("invoice_detail in", values, "invoiceDetail");
            return (Criteria) this;
        }

        public Criteria andInvoiceDetailNotIn(List<String> values) {
            addCriterion("invoice_detail not in", values, "invoiceDetail");
            return (Criteria) this;
        }

        public Criteria andInvoiceDetailBetween(String value1, String value2) {
            addCriterion("invoice_detail between", value1, value2, "invoiceDetail");
            return (Criteria) this;
        }

        public Criteria andInvoiceDetailNotBetween(String value1, String value2) {
            addCriterion("invoice_detail not between", value1, value2, "invoiceDetail");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andStaffDetailIsNull() {
            addCriterion("staff_detail is null");
            return (Criteria) this;
        }

        public Criteria andStaffDetailIsNotNull() {
            addCriterion("staff_detail is not null");
            return (Criteria) this;
        }

        public Criteria andStaffDetailEqualTo(String value) {
            addCriterion("staff_detail =", value, "staffDetail");
            return (Criteria) this;
        }

        public Criteria andStaffDetailNotEqualTo(String value) {
            addCriterion("staff_detail <>", value, "staffDetail");
            return (Criteria) this;
        }

        public Criteria andStaffDetailGreaterThan(String value) {
            addCriterion("staff_detail >", value, "staffDetail");
            return (Criteria) this;
        }

        public Criteria andStaffDetailGreaterThanOrEqualTo(String value) {
            addCriterion("staff_detail >=", value, "staffDetail");
            return (Criteria) this;
        }

        public Criteria andStaffDetailLessThan(String value) {
            addCriterion("staff_detail <", value, "staffDetail");
            return (Criteria) this;
        }

        public Criteria andStaffDetailLessThanOrEqualTo(String value) {
            addCriterion("staff_detail <=", value, "staffDetail");
            return (Criteria) this;
        }

        public Criteria andStaffDetailLike(String value) {
            addCriterion("staff_detail like", value, "staffDetail");
            return (Criteria) this;
        }

        public Criteria andStaffDetailNotLike(String value) {
            addCriterion("staff_detail not like", value, "staffDetail");
            return (Criteria) this;
        }

        public Criteria andStaffDetailIn(List<String> values) {
            addCriterion("staff_detail in", values, "staffDetail");
            return (Criteria) this;
        }

        public Criteria andStaffDetailNotIn(List<String> values) {
            addCriterion("staff_detail not in", values, "staffDetail");
            return (Criteria) this;
        }

        public Criteria andStaffDetailBetween(String value1, String value2) {
            addCriterion("staff_detail between", value1, value2, "staffDetail");
            return (Criteria) this;
        }

        public Criteria andStaffDetailNotBetween(String value1, String value2) {
            addCriterion("staff_detail not between", value1, value2, "staffDetail");
            return (Criteria) this;
        }

        public Criteria andStaffTypeIsNull() {
            addCriterion("staff_type is null");
            return (Criteria) this;
        }

        public Criteria andStaffTypeIsNotNull() {
            addCriterion("staff_type is not null");
            return (Criteria) this;
        }

        public Criteria andStaffTypeEqualTo(Integer value) {
            addCriterion("staff_type =", value, "staffType");
            return (Criteria) this;
        }

        public Criteria andStaffTypeNotEqualTo(Integer value) {
            addCriterion("staff_type <>", value, "staffType");
            return (Criteria) this;
        }

        public Criteria andStaffTypeGreaterThan(Integer value) {
            addCriterion("staff_type >", value, "staffType");
            return (Criteria) this;
        }

        public Criteria andStaffTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("staff_type >=", value, "staffType");
            return (Criteria) this;
        }

        public Criteria andStaffTypeLessThan(Integer value) {
            addCriterion("staff_type <", value, "staffType");
            return (Criteria) this;
        }

        public Criteria andStaffTypeLessThanOrEqualTo(Integer value) {
            addCriterion("staff_type <=", value, "staffType");
            return (Criteria) this;
        }

        public Criteria andStaffTypeIn(List<Integer> values) {
            addCriterion("staff_type in", values, "staffType");
            return (Criteria) this;
        }

        public Criteria andStaffTypeNotIn(List<Integer> values) {
            addCriterion("staff_type not in", values, "staffType");
            return (Criteria) this;
        }

        public Criteria andStaffTypeBetween(Integer value1, Integer value2) {
            addCriterion("staff_type between", value1, value2, "staffType");
            return (Criteria) this;
        }

        public Criteria andStaffTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("staff_type not between", value1, value2, "staffType");
            return (Criteria) this;
        }

        public Criteria andResumePathIsNull() {
            addCriterion("resume_path is null");
            return (Criteria) this;
        }

        public Criteria andResumePathIsNotNull() {
            addCriterion("resume_path is not null");
            return (Criteria) this;
        }

        public Criteria andResumePathEqualTo(String value) {
            addCriterion("resume_path =", value, "resumePath");
            return (Criteria) this;
        }

        public Criteria andResumePathNotEqualTo(String value) {
            addCriterion("resume_path <>", value, "resumePath");
            return (Criteria) this;
        }

        public Criteria andResumePathGreaterThan(String value) {
            addCriterion("resume_path >", value, "resumePath");
            return (Criteria) this;
        }

        public Criteria andResumePathGreaterThanOrEqualTo(String value) {
            addCriterion("resume_path >=", value, "resumePath");
            return (Criteria) this;
        }

        public Criteria andResumePathLessThan(String value) {
            addCriterion("resume_path <", value, "resumePath");
            return (Criteria) this;
        }

        public Criteria andResumePathLessThanOrEqualTo(String value) {
            addCriterion("resume_path <=", value, "resumePath");
            return (Criteria) this;
        }

        public Criteria andResumePathLike(String value) {
            addCriterion("resume_path like", value, "resumePath");
            return (Criteria) this;
        }

        public Criteria andResumePathNotLike(String value) {
            addCriterion("resume_path not like", value, "resumePath");
            return (Criteria) this;
        }

        public Criteria andResumePathIn(List<String> values) {
            addCriterion("resume_path in", values, "resumePath");
            return (Criteria) this;
        }

        public Criteria andResumePathNotIn(List<String> values) {
            addCriterion("resume_path not in", values, "resumePath");
            return (Criteria) this;
        }

        public Criteria andResumePathBetween(String value1, String value2) {
            addCriterion("resume_path between", value1, value2, "resumePath");
            return (Criteria) this;
        }

        public Criteria andResumePathNotBetween(String value1, String value2) {
            addCriterion("resume_path not between", value1, value2, "resumePath");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNull() {
            addCriterion("del_flag is null");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNotNull() {
            addCriterion("del_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDelFlagEqualTo(Integer value) {
            addCriterion("del_flag =", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotEqualTo(Integer value) {
            addCriterion("del_flag <>", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThan(Integer value) {
            addCriterion("del_flag >", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("del_flag >=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThan(Integer value) {
            addCriterion("del_flag <", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThanOrEqualTo(Integer value) {
            addCriterion("del_flag <=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagIn(List<Integer> values) {
            addCriterion("del_flag in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotIn(List<Integer> values) {
            addCriterion("del_flag not in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagBetween(Integer value1, Integer value2) {
            addCriterion("del_flag between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("del_flag not between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameIsNull() {
            addCriterion("create_user_name is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameIsNotNull() {
            addCriterion("create_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameEqualTo(String value) {
            addCriterion("create_user_name =", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotEqualTo(String value) {
            addCriterion("create_user_name <>", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameGreaterThan(String value) {
            addCriterion("create_user_name >", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("create_user_name >=", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameLessThan(String value) {
            addCriterion("create_user_name <", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameLessThanOrEqualTo(String value) {
            addCriterion("create_user_name <=", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameLike(String value) {
            addCriterion("create_user_name like", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotLike(String value) {
            addCriterion("create_user_name not like", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameIn(List<String> values) {
            addCriterion("create_user_name in", values, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotIn(List<String> values) {
            addCriterion("create_user_name not in", values, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameBetween(String value1, String value2) {
            addCriterion("create_user_name between", value1, value2, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotBetween(String value1, String value2) {
            addCriterion("create_user_name not between", value1, value2, "createUserName");
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

        public Criteria andUpdateUserNameIsNull() {
            addCriterion("update_user_name is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameIsNotNull() {
            addCriterion("update_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameEqualTo(String value) {
            addCriterion("update_user_name =", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotEqualTo(String value) {
            addCriterion("update_user_name <>", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameGreaterThan(String value) {
            addCriterion("update_user_name >", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("update_user_name >=", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameLessThan(String value) {
            addCriterion("update_user_name <", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameLessThanOrEqualTo(String value) {
            addCriterion("update_user_name <=", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameLike(String value) {
            addCriterion("update_user_name like", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotLike(String value) {
            addCriterion("update_user_name not like", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameIn(List<String> values) {
            addCriterion("update_user_name in", values, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotIn(List<String> values) {
            addCriterion("update_user_name not in", values, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameBetween(String value1, String value2) {
            addCriterion("update_user_name between", value1, value2, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotBetween(String value1, String value2) {
            addCriterion("update_user_name not between", value1, value2, "updateUserName");
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