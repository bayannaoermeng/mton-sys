package com.marathon.domain;

import java.util.ArrayList;
import java.util.List;

public class MrtonProcCfgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public MrtonProcCfgExample() {
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

        public Criteria andProcNameIsNull() {
            addCriterion("proc_name is null");
            return (Criteria) this;
        }

        public Criteria andProcNameIsNotNull() {
            addCriterion("proc_name is not null");
            return (Criteria) this;
        }

        public Criteria andProcNameEqualTo(String value) {
            addCriterion("proc_name =", value, "procName");
            return (Criteria) this;
        }

        public Criteria andProcNameNotEqualTo(String value) {
            addCriterion("proc_name <>", value, "procName");
            return (Criteria) this;
        }

        public Criteria andProcNameGreaterThan(String value) {
            addCriterion("proc_name >", value, "procName");
            return (Criteria) this;
        }

        public Criteria andProcNameGreaterThanOrEqualTo(String value) {
            addCriterion("proc_name >=", value, "procName");
            return (Criteria) this;
        }

        public Criteria andProcNameLessThan(String value) {
            addCriterion("proc_name <", value, "procName");
            return (Criteria) this;
        }

        public Criteria andProcNameLessThanOrEqualTo(String value) {
            addCriterion("proc_name <=", value, "procName");
            return (Criteria) this;
        }

        public Criteria andProcNameLike(String value) {
            addCriterion("proc_name like", value, "procName");
            return (Criteria) this;
        }

        public Criteria andProcNameNotLike(String value) {
            addCriterion("proc_name not like", value, "procName");
            return (Criteria) this;
        }

        public Criteria andProcNameIn(List<String> values) {
            addCriterion("proc_name in", values, "procName");
            return (Criteria) this;
        }

        public Criteria andProcNameNotIn(List<String> values) {
            addCriterion("proc_name not in", values, "procName");
            return (Criteria) this;
        }

        public Criteria andProcNameBetween(String value1, String value2) {
            addCriterion("proc_name between", value1, value2, "procName");
            return (Criteria) this;
        }

        public Criteria andProcNameNotBetween(String value1, String value2) {
            addCriterion("proc_name not between", value1, value2, "procName");
            return (Criteria) this;
        }

        public Criteria andProcSeqIsNull() {
            addCriterion("proc_seq is null");
            return (Criteria) this;
        }

        public Criteria andProcSeqIsNotNull() {
            addCriterion("proc_seq is not null");
            return (Criteria) this;
        }

        public Criteria andProcSeqEqualTo(Integer value) {
            addCriterion("proc_seq =", value, "procSeq");
            return (Criteria) this;
        }

        public Criteria andProcSeqNotEqualTo(Integer value) {
            addCriterion("proc_seq <>", value, "procSeq");
            return (Criteria) this;
        }

        public Criteria andProcSeqGreaterThan(Integer value) {
            addCriterion("proc_seq >", value, "procSeq");
            return (Criteria) this;
        }

        public Criteria andProcSeqGreaterThanOrEqualTo(Integer value) {
            addCriterion("proc_seq >=", value, "procSeq");
            return (Criteria) this;
        }

        public Criteria andProcSeqLessThan(Integer value) {
            addCriterion("proc_seq <", value, "procSeq");
            return (Criteria) this;
        }

        public Criteria andProcSeqLessThanOrEqualTo(Integer value) {
            addCriterion("proc_seq <=", value, "procSeq");
            return (Criteria) this;
        }

        public Criteria andProcSeqIn(List<Integer> values) {
            addCriterion("proc_seq in", values, "procSeq");
            return (Criteria) this;
        }

        public Criteria andProcSeqNotIn(List<Integer> values) {
            addCriterion("proc_seq not in", values, "procSeq");
            return (Criteria) this;
        }

        public Criteria andProcSeqBetween(Integer value1, Integer value2) {
            addCriterion("proc_seq between", value1, value2, "procSeq");
            return (Criteria) this;
        }

        public Criteria andProcSeqNotBetween(Integer value1, Integer value2) {
            addCriterion("proc_seq not between", value1, value2, "procSeq");
            return (Criteria) this;
        }

        public Criteria andParentProcIdIsNull() {
            addCriterion("parent_proc_id is null");
            return (Criteria) this;
        }

        public Criteria andParentProcIdIsNotNull() {
            addCriterion("parent_proc_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentProcIdEqualTo(String value) {
            addCriterion("parent_proc_id =", value, "parentProcId");
            return (Criteria) this;
        }

        public Criteria andParentProcIdNotEqualTo(String value) {
            addCriterion("parent_proc_id <>", value, "parentProcId");
            return (Criteria) this;
        }

        public Criteria andParentProcIdGreaterThan(String value) {
            addCriterion("parent_proc_id >", value, "parentProcId");
            return (Criteria) this;
        }

        public Criteria andParentProcIdGreaterThanOrEqualTo(String value) {
            addCriterion("parent_proc_id >=", value, "parentProcId");
            return (Criteria) this;
        }

        public Criteria andParentProcIdLessThan(String value) {
            addCriterion("parent_proc_id <", value, "parentProcId");
            return (Criteria) this;
        }

        public Criteria andParentProcIdLessThanOrEqualTo(String value) {
            addCriterion("parent_proc_id <=", value, "parentProcId");
            return (Criteria) this;
        }

        public Criteria andParentProcIdLike(String value) {
            addCriterion("parent_proc_id like", value, "parentProcId");
            return (Criteria) this;
        }

        public Criteria andParentProcIdNotLike(String value) {
            addCriterion("parent_proc_id not like", value, "parentProcId");
            return (Criteria) this;
        }

        public Criteria andParentProcIdIn(List<String> values) {
            addCriterion("parent_proc_id in", values, "parentProcId");
            return (Criteria) this;
        }

        public Criteria andParentProcIdNotIn(List<String> values) {
            addCriterion("parent_proc_id not in", values, "parentProcId");
            return (Criteria) this;
        }

        public Criteria andParentProcIdBetween(String value1, String value2) {
            addCriterion("parent_proc_id between", value1, value2, "parentProcId");
            return (Criteria) this;
        }

        public Criteria andParentProcIdNotBetween(String value1, String value2) {
            addCriterion("parent_proc_id not between", value1, value2, "parentProcId");
            return (Criteria) this;
        }

        public Criteria andComparativelyToMrtonIsNull() {
            addCriterion("comparatively_to_mrton is null");
            return (Criteria) this;
        }

        public Criteria andComparativelyToMrtonIsNotNull() {
            addCriterion("comparatively_to_mrton is not null");
            return (Criteria) this;
        }

        public Criteria andComparativelyToMrtonEqualTo(Integer value) {
            addCriterion("comparatively_to_mrton =", value, "comparativelyToMrton");
            return (Criteria) this;
        }

        public Criteria andComparativelyToMrtonNotEqualTo(Integer value) {
            addCriterion("comparatively_to_mrton <>", value, "comparativelyToMrton");
            return (Criteria) this;
        }

        public Criteria andComparativelyToMrtonGreaterThan(Integer value) {
            addCriterion("comparatively_to_mrton >", value, "comparativelyToMrton");
            return (Criteria) this;
        }

        public Criteria andComparativelyToMrtonGreaterThanOrEqualTo(Integer value) {
            addCriterion("comparatively_to_mrton >=", value, "comparativelyToMrton");
            return (Criteria) this;
        }

        public Criteria andComparativelyToMrtonLessThan(Integer value) {
            addCriterion("comparatively_to_mrton <", value, "comparativelyToMrton");
            return (Criteria) this;
        }

        public Criteria andComparativelyToMrtonLessThanOrEqualTo(Integer value) {
            addCriterion("comparatively_to_mrton <=", value, "comparativelyToMrton");
            return (Criteria) this;
        }

        public Criteria andComparativelyToMrtonIn(List<Integer> values) {
            addCriterion("comparatively_to_mrton in", values, "comparativelyToMrton");
            return (Criteria) this;
        }

        public Criteria andComparativelyToMrtonNotIn(List<Integer> values) {
            addCriterion("comparatively_to_mrton not in", values, "comparativelyToMrton");
            return (Criteria) this;
        }

        public Criteria andComparativelyToMrtonBetween(Integer value1, Integer value2) {
            addCriterion("comparatively_to_mrton between", value1, value2, "comparativelyToMrton");
            return (Criteria) this;
        }

        public Criteria andComparativelyToMrtonNotBetween(Integer value1, Integer value2) {
            addCriterion("comparatively_to_mrton not between", value1, value2, "comparativelyToMrton");
            return (Criteria) this;
        }

        public Criteria andStarttimeOffsetIsNull() {
            addCriterion("starttime_offset is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeOffsetIsNotNull() {
            addCriterion("starttime_offset is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeOffsetEqualTo(Integer value) {
            addCriterion("starttime_offset =", value, "starttimeOffset");
            return (Criteria) this;
        }

        public Criteria andStarttimeOffsetNotEqualTo(Integer value) {
            addCriterion("starttime_offset <>", value, "starttimeOffset");
            return (Criteria) this;
        }

        public Criteria andStarttimeOffsetGreaterThan(Integer value) {
            addCriterion("starttime_offset >", value, "starttimeOffset");
            return (Criteria) this;
        }

        public Criteria andStarttimeOffsetGreaterThanOrEqualTo(Integer value) {
            addCriterion("starttime_offset >=", value, "starttimeOffset");
            return (Criteria) this;
        }

        public Criteria andStarttimeOffsetLessThan(Integer value) {
            addCriterion("starttime_offset <", value, "starttimeOffset");
            return (Criteria) this;
        }

        public Criteria andStarttimeOffsetLessThanOrEqualTo(Integer value) {
            addCriterion("starttime_offset <=", value, "starttimeOffset");
            return (Criteria) this;
        }

        public Criteria andStarttimeOffsetIn(List<Integer> values) {
            addCriterion("starttime_offset in", values, "starttimeOffset");
            return (Criteria) this;
        }

        public Criteria andStarttimeOffsetNotIn(List<Integer> values) {
            addCriterion("starttime_offset not in", values, "starttimeOffset");
            return (Criteria) this;
        }

        public Criteria andStarttimeOffsetBetween(Integer value1, Integer value2) {
            addCriterion("starttime_offset between", value1, value2, "starttimeOffset");
            return (Criteria) this;
        }

        public Criteria andStarttimeOffsetNotBetween(Integer value1, Integer value2) {
            addCriterion("starttime_offset not between", value1, value2, "starttimeOffset");
            return (Criteria) this;
        }

        public Criteria andEndtimeOffsetIsNull() {
            addCriterion("endtime_offset is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeOffsetIsNotNull() {
            addCriterion("endtime_offset is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeOffsetEqualTo(Integer value) {
            addCriterion("endtime_offset =", value, "endtimeOffset");
            return (Criteria) this;
        }

        public Criteria andEndtimeOffsetNotEqualTo(Integer value) {
            addCriterion("endtime_offset <>", value, "endtimeOffset");
            return (Criteria) this;
        }

        public Criteria andEndtimeOffsetGreaterThan(Integer value) {
            addCriterion("endtime_offset >", value, "endtimeOffset");
            return (Criteria) this;
        }

        public Criteria andEndtimeOffsetGreaterThanOrEqualTo(Integer value) {
            addCriterion("endtime_offset >=", value, "endtimeOffset");
            return (Criteria) this;
        }

        public Criteria andEndtimeOffsetLessThan(Integer value) {
            addCriterion("endtime_offset <", value, "endtimeOffset");
            return (Criteria) this;
        }

        public Criteria andEndtimeOffsetLessThanOrEqualTo(Integer value) {
            addCriterion("endtime_offset <=", value, "endtimeOffset");
            return (Criteria) this;
        }

        public Criteria andEndtimeOffsetIn(List<Integer> values) {
            addCriterion("endtime_offset in", values, "endtimeOffset");
            return (Criteria) this;
        }

        public Criteria andEndtimeOffsetNotIn(List<Integer> values) {
            addCriterion("endtime_offset not in", values, "endtimeOffset");
            return (Criteria) this;
        }

        public Criteria andEndtimeOffsetBetween(Integer value1, Integer value2) {
            addCriterion("endtime_offset between", value1, value2, "endtimeOffset");
            return (Criteria) this;
        }

        public Criteria andEndtimeOffsetNotBetween(Integer value1, Integer value2) {
            addCriterion("endtime_offset not between", value1, value2, "endtimeOffset");
            return (Criteria) this;
        }

        public Criteria andProcContentIsNull() {
            addCriterion("proc_content is null");
            return (Criteria) this;
        }

        public Criteria andProcContentIsNotNull() {
            addCriterion("proc_content is not null");
            return (Criteria) this;
        }

        public Criteria andProcContentEqualTo(String value) {
            addCriterion("proc_content =", value, "procContent");
            return (Criteria) this;
        }

        public Criteria andProcContentNotEqualTo(String value) {
            addCriterion("proc_content <>", value, "procContent");
            return (Criteria) this;
        }

        public Criteria andProcContentGreaterThan(String value) {
            addCriterion("proc_content >", value, "procContent");
            return (Criteria) this;
        }

        public Criteria andProcContentGreaterThanOrEqualTo(String value) {
            addCriterion("proc_content >=", value, "procContent");
            return (Criteria) this;
        }

        public Criteria andProcContentLessThan(String value) {
            addCriterion("proc_content <", value, "procContent");
            return (Criteria) this;
        }

        public Criteria andProcContentLessThanOrEqualTo(String value) {
            addCriterion("proc_content <=", value, "procContent");
            return (Criteria) this;
        }

        public Criteria andProcContentLike(String value) {
            addCriterion("proc_content like", value, "procContent");
            return (Criteria) this;
        }

        public Criteria andProcContentNotLike(String value) {
            addCriterion("proc_content not like", value, "procContent");
            return (Criteria) this;
        }

        public Criteria andProcContentIn(List<String> values) {
            addCriterion("proc_content in", values, "procContent");
            return (Criteria) this;
        }

        public Criteria andProcContentNotIn(List<String> values) {
            addCriterion("proc_content not in", values, "procContent");
            return (Criteria) this;
        }

        public Criteria andProcContentBetween(String value1, String value2) {
            addCriterion("proc_content between", value1, value2, "procContent");
            return (Criteria) this;
        }

        public Criteria andProcContentNotBetween(String value1, String value2) {
            addCriterion("proc_content not between", value1, value2, "procContent");
            return (Criteria) this;
        }

        public Criteria andProcDescriIsNull() {
            addCriterion("proc_descri is null");
            return (Criteria) this;
        }

        public Criteria andProcDescriIsNotNull() {
            addCriterion("proc_descri is not null");
            return (Criteria) this;
        }

        public Criteria andProcDescriEqualTo(String value) {
            addCriterion("proc_descri =", value, "procDescri");
            return (Criteria) this;
        }

        public Criteria andProcDescriNotEqualTo(String value) {
            addCriterion("proc_descri <>", value, "procDescri");
            return (Criteria) this;
        }

        public Criteria andProcDescriGreaterThan(String value) {
            addCriterion("proc_descri >", value, "procDescri");
            return (Criteria) this;
        }

        public Criteria andProcDescriGreaterThanOrEqualTo(String value) {
            addCriterion("proc_descri >=", value, "procDescri");
            return (Criteria) this;
        }

        public Criteria andProcDescriLessThan(String value) {
            addCriterion("proc_descri <", value, "procDescri");
            return (Criteria) this;
        }

        public Criteria andProcDescriLessThanOrEqualTo(String value) {
            addCriterion("proc_descri <=", value, "procDescri");
            return (Criteria) this;
        }

        public Criteria andProcDescriLike(String value) {
            addCriterion("proc_descri like", value, "procDescri");
            return (Criteria) this;
        }

        public Criteria andProcDescriNotLike(String value) {
            addCriterion("proc_descri not like", value, "procDescri");
            return (Criteria) this;
        }

        public Criteria andProcDescriIn(List<String> values) {
            addCriterion("proc_descri in", values, "procDescri");
            return (Criteria) this;
        }

        public Criteria andProcDescriNotIn(List<String> values) {
            addCriterion("proc_descri not in", values, "procDescri");
            return (Criteria) this;
        }

        public Criteria andProcDescriBetween(String value1, String value2) {
            addCriterion("proc_descri between", value1, value2, "procDescri");
            return (Criteria) this;
        }

        public Criteria andProcDescriNotBetween(String value1, String value2) {
            addCriterion("proc_descri not between", value1, value2, "procDescri");
            return (Criteria) this;
        }

        public Criteria andAttachResourceIdIsNull() {
            addCriterion("attach_resource_id is null");
            return (Criteria) this;
        }

        public Criteria andAttachResourceIdIsNotNull() {
            addCriterion("attach_resource_id is not null");
            return (Criteria) this;
        }

        public Criteria andAttachResourceIdEqualTo(String value) {
            addCriterion("attach_resource_id =", value, "attachResourceId");
            return (Criteria) this;
        }

        public Criteria andAttachResourceIdNotEqualTo(String value) {
            addCriterion("attach_resource_id <>", value, "attachResourceId");
            return (Criteria) this;
        }

        public Criteria andAttachResourceIdGreaterThan(String value) {
            addCriterion("attach_resource_id >", value, "attachResourceId");
            return (Criteria) this;
        }

        public Criteria andAttachResourceIdGreaterThanOrEqualTo(String value) {
            addCriterion("attach_resource_id >=", value, "attachResourceId");
            return (Criteria) this;
        }

        public Criteria andAttachResourceIdLessThan(String value) {
            addCriterion("attach_resource_id <", value, "attachResourceId");
            return (Criteria) this;
        }

        public Criteria andAttachResourceIdLessThanOrEqualTo(String value) {
            addCriterion("attach_resource_id <=", value, "attachResourceId");
            return (Criteria) this;
        }

        public Criteria andAttachResourceIdLike(String value) {
            addCriterion("attach_resource_id like", value, "attachResourceId");
            return (Criteria) this;
        }

        public Criteria andAttachResourceIdNotLike(String value) {
            addCriterion("attach_resource_id not like", value, "attachResourceId");
            return (Criteria) this;
        }

        public Criteria andAttachResourceIdIn(List<String> values) {
            addCriterion("attach_resource_id in", values, "attachResourceId");
            return (Criteria) this;
        }

        public Criteria andAttachResourceIdNotIn(List<String> values) {
            addCriterion("attach_resource_id not in", values, "attachResourceId");
            return (Criteria) this;
        }

        public Criteria andAttachResourceIdBetween(String value1, String value2) {
            addCriterion("attach_resource_id between", value1, value2, "attachResourceId");
            return (Criteria) this;
        }

        public Criteria andAttachResourceIdNotBetween(String value1, String value2) {
            addCriterion("attach_resource_id not between", value1, value2, "attachResourceId");
            return (Criteria) this;
        }

        public Criteria andProcStatusIsNull() {
            addCriterion("proc_status is null");
            return (Criteria) this;
        }

        public Criteria andProcStatusIsNotNull() {
            addCriterion("proc_status is not null");
            return (Criteria) this;
        }

        public Criteria andProcStatusEqualTo(Integer value) {
            addCriterion("proc_status =", value, "procStatus");
            return (Criteria) this;
        }

        public Criteria andProcStatusNotEqualTo(Integer value) {
            addCriterion("proc_status <>", value, "procStatus");
            return (Criteria) this;
        }

        public Criteria andProcStatusGreaterThan(Integer value) {
            addCriterion("proc_status >", value, "procStatus");
            return (Criteria) this;
        }

        public Criteria andProcStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("proc_status >=", value, "procStatus");
            return (Criteria) this;
        }

        public Criteria andProcStatusLessThan(Integer value) {
            addCriterion("proc_status <", value, "procStatus");
            return (Criteria) this;
        }

        public Criteria andProcStatusLessThanOrEqualTo(Integer value) {
            addCriterion("proc_status <=", value, "procStatus");
            return (Criteria) this;
        }

        public Criteria andProcStatusIn(List<Integer> values) {
            addCriterion("proc_status in", values, "procStatus");
            return (Criteria) this;
        }

        public Criteria andProcStatusNotIn(List<Integer> values) {
            addCriterion("proc_status not in", values, "procStatus");
            return (Criteria) this;
        }

        public Criteria andProcStatusBetween(Integer value1, Integer value2) {
            addCriterion("proc_status between", value1, value2, "procStatus");
            return (Criteria) this;
        }

        public Criteria andProcStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("proc_status not between", value1, value2, "procStatus");
            return (Criteria) this;
        }

        public Criteria andReservedIsNull() {
            addCriterion("reserved is null");
            return (Criteria) this;
        }

        public Criteria andReservedIsNotNull() {
            addCriterion("reserved is not null");
            return (Criteria) this;
        }

        public Criteria andReservedEqualTo(String value) {
            addCriterion("reserved =", value, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedNotEqualTo(String value) {
            addCriterion("reserved <>", value, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedGreaterThan(String value) {
            addCriterion("reserved >", value, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedGreaterThanOrEqualTo(String value) {
            addCriterion("reserved >=", value, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedLessThan(String value) {
            addCriterion("reserved <", value, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedLessThanOrEqualTo(String value) {
            addCriterion("reserved <=", value, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedLike(String value) {
            addCriterion("reserved like", value, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedNotLike(String value) {
            addCriterion("reserved not like", value, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedIn(List<String> values) {
            addCriterion("reserved in", values, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedNotIn(List<String> values) {
            addCriterion("reserved not in", values, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedBetween(String value1, String value2) {
            addCriterion("reserved between", value1, value2, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedNotBetween(String value1, String value2) {
            addCriterion("reserved not between", value1, value2, "reserved");
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