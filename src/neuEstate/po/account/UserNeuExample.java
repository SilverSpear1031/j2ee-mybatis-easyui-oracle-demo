package neuEstate.po.account;

import java.util.ArrayList;
import java.util.List;

public class UserNeuExample {
    //用于分页的page当前页和rows所需行数
    private Integer startNum;
    private Integer addNum;

    public Integer getStartNum() {
        return startNum;
    }

    public void setStartNum(Integer startNum) {
        this.startNum = startNum;
    }

    public Integer getAddNum() {
        return addNum;
    }

    public void setAddNum(Integer addNum) {
        this.addNum = addNum;
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table USER_NEU
     *
     * @mbggenerated Sun Jul 30 22:26:32 CST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table USER_NEU
     *
     * @mbggenerated Sun Jul 30 22:26:32 CST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table USER_NEU
     *
     * @mbggenerated Sun Jul 30 22:26:32 CST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_NEU
     *
     * @mbggenerated Sun Jul 30 22:26:32 CST 2017
     */
    public UserNeuExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_NEU
     *
     * @mbggenerated Sun Jul 30 22:26:32 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_NEU
     *
     * @mbggenerated Sun Jul 30 22:26:32 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_NEU
     *
     * @mbggenerated Sun Jul 30 22:26:32 CST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_NEU
     *
     * @mbggenerated Sun Jul 30 22:26:32 CST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_NEU
     *
     * @mbggenerated Sun Jul 30 22:26:32 CST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_NEU
     *
     * @mbggenerated Sun Jul 30 22:26:32 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_NEU
     *
     * @mbggenerated Sun Jul 30 22:26:32 CST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_NEU
     *
     * @mbggenerated Sun Jul 30 22:26:32 CST 2017
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_NEU
     *
     * @mbggenerated Sun Jul 30 22:26:32 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_NEU
     *
     * @mbggenerated Sun Jul 30 22:26:32 CST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table USER_NEU
     *
     * @mbggenerated Sun Jul 30 22:26:32 CST 2017
     */
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

        public Criteria andUseraccountIsNull() {
            addCriterion("userAccount is null");
            return (Criteria) this;
        }

        public Criteria andUseraccountIsNotNull() {
            addCriterion("userAccount is not null");
            return (Criteria) this;
        }

        public Criteria andUseraccountEqualTo(String value) {
            addCriterion("\"userAccount\" =", value, "useraccount");
            return (Criteria) this;
        }

        public Criteria andUseraccountNotEqualTo(String value) {
            addCriterion("userAccount <>", value, "useraccount");
            return (Criteria) this;
        }

        public Criteria andUseraccountGreaterThan(String value) {
            addCriterion("userAccount >", value, "useraccount");
            return (Criteria) this;
        }

        public Criteria andUseraccountGreaterThanOrEqualTo(String value) {
            addCriterion("userAccount >=", value, "useraccount");
            return (Criteria) this;
        }

        public Criteria andUseraccountLessThan(String value) {
            addCriterion("userAccount <", value, "useraccount");
            return (Criteria) this;
        }

        public Criteria andUseraccountLessThanOrEqualTo(String value) {
            addCriterion("userAccount <=", value, "useraccount");
            return (Criteria) this;
        }

        public Criteria andUseraccountLike(String value) {
            addCriterion("\"userAccount\" like", value, "useraccount");
            return (Criteria) this;
        }

        public Criteria andUseraccountNotLike(String value) {
            addCriterion("userAccount not like", value, "useraccount");
            return (Criteria) this;
        }

        public Criteria andUseraccountIn(List<String> values) {
            addCriterion("\"userAccount\" in", values, "useraccount");
            return (Criteria) this;
        }

        public Criteria andUseraccountNotIn(List<String> values) {
            addCriterion("userAccount not in", values, "useraccount");
            return (Criteria) this;
        }

        public Criteria andUseraccountBetween(String value1, String value2) {
            addCriterion("userAccount between", value1, value2, "useraccount");
            return (Criteria) this;
        }

        public Criteria andUseraccountNotBetween(String value1, String value2) {
            addCriterion("userAccount not between", value1, value2, "useraccount");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("userName is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("userName is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("\"userName =\"", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("userName <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("userName >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("userName >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("userName <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("userName <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("\"userName\" like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("userName not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("userName in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("userName not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("userName between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("userName not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUserpasswordIsNull() {
            addCriterion("userPassword is null");
            return (Criteria) this;
        }

        public Criteria andUserpasswordIsNotNull() {
            addCriterion("userPassword is not null");
            return (Criteria) this;
        }

        public Criteria andUserpasswordEqualTo(String value) {
            addCriterion("\"userPassword\" =", value, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordNotEqualTo(String value) {
            addCriterion("userPassword <>", value, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordGreaterThan(String value) {
            addCriterion("userPassword >", value, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordGreaterThanOrEqualTo(String value) {
            addCriterion("userPassword >=", value, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordLessThan(String value) {
            addCriterion("userPassword <", value, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordLessThanOrEqualTo(String value) {
            addCriterion("userPassword <=", value, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordLike(String value) {
            addCriterion("userPassword like", value, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordNotLike(String value) {
            addCriterion("userPassword not like", value, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordIn(List<String> values) {
            addCriterion("userPassword in", values, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordNotIn(List<String> values) {
            addCriterion("userPassword not in", values, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordBetween(String value1, String value2) {
            addCriterion("userPassword between", value1, value2, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordNotBetween(String value1, String value2) {
            addCriterion("userPassword not between", value1, value2, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserphonenumberIsNull() {
            addCriterion("userPhoneNumber is null");
            return (Criteria) this;
        }

        public Criteria andUserphonenumberIsNotNull() {
            addCriterion("userPhoneNumber is not null");
            return (Criteria) this;
        }

        public Criteria andUserphonenumberEqualTo(String value) {
            addCriterion("userPhoneNumber =", value, "userphonenumber");
            return (Criteria) this;
        }

        public Criteria andUserphonenumberNotEqualTo(String value) {
            addCriterion("userPhoneNumber <>", value, "userphonenumber");
            return (Criteria) this;
        }

        public Criteria andUserphonenumberGreaterThan(String value) {
            addCriterion("userPhoneNumber >", value, "userphonenumber");
            return (Criteria) this;
        }

        public Criteria andUserphonenumberGreaterThanOrEqualTo(String value) {
            addCriterion("userPhoneNumber >=", value, "userphonenumber");
            return (Criteria) this;
        }

        public Criteria andUserphonenumberLessThan(String value) {
            addCriterion("userPhoneNumber <", value, "userphonenumber");
            return (Criteria) this;
        }

        public Criteria andUserphonenumberLessThanOrEqualTo(String value) {
            addCriterion("userPhoneNumber <=", value, "userphonenumber");
            return (Criteria) this;
        }

        public Criteria andUserphonenumberLike(String value) {
            addCriterion("userPhoneNumber like", value, "userphonenumber");
            return (Criteria) this;
        }

        public Criteria andUserphonenumberNotLike(String value) {
            addCriterion("userPhoneNumber not like", value, "userphonenumber");
            return (Criteria) this;
        }

        public Criteria andUserphonenumberIn(List<String> values) {
            addCriterion("userPhoneNumber in", values, "userphonenumber");
            return (Criteria) this;
        }

        public Criteria andUserphonenumberNotIn(List<String> values) {
            addCriterion("userPhoneNumber not in", values, "userphonenumber");
            return (Criteria) this;
        }

        public Criteria andUserphonenumberBetween(String value1, String value2) {
            addCriterion("userPhoneNumber between", value1, value2, "userphonenumber");
            return (Criteria) this;
        }

        public Criteria andUserphonenumberNotBetween(String value1, String value2) {
            addCriterion("userPhoneNumber not between", value1, value2, "userphonenumber");
            return (Criteria) this;
        }

        public Criteria andUseremailIsNull() {
            addCriterion("userEmail is null");
            return (Criteria) this;
        }

        public Criteria andUseremailIsNotNull() {
            addCriterion("userEmail is not null");
            return (Criteria) this;
        }

        public Criteria andUseremailEqualTo(String value) {
            addCriterion("userEmail =", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailNotEqualTo(String value) {
            addCriterion("userEmail <>", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailGreaterThan(String value) {
            addCriterion("userEmail >", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailGreaterThanOrEqualTo(String value) {
            addCriterion("userEmail >=", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailLessThan(String value) {
            addCriterion("userEmail <", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailLessThanOrEqualTo(String value) {
            addCriterion("userEmail <=", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailLike(String value) {
            addCriterion("userEmail like", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailNotLike(String value) {
            addCriterion("userEmail not like", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailIn(List<String> values) {
            addCriterion("userEmail in", values, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailNotIn(List<String> values) {
            addCriterion("userEmail not in", values, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailBetween(String value1, String value2) {
            addCriterion("userEmail between", value1, value2, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailNotBetween(String value1, String value2) {
            addCriterion("userEmail not between", value1, value2, "useremail");
            return (Criteria) this;
        }

        public Criteria andUserauthorityIsNull() {
            addCriterion("userAuthority is null");
            return (Criteria) this;
        }

        public Criteria andUserauthorityIsNotNull() {
            addCriterion("userAuthority is not null");
            return (Criteria) this;
        }

        public Criteria andUserauthorityEqualTo(String value) {
            addCriterion("userAuthority =", value, "userauthority");
            return (Criteria) this;
        }

        public Criteria andUserauthorityNotEqualTo(String value) {
            addCriterion("userAuthority <>", value, "userauthority");
            return (Criteria) this;
        }

        public Criteria andUserauthorityGreaterThan(String value) {
            addCriterion("userAuthority >", value, "userauthority");
            return (Criteria) this;
        }

        public Criteria andUserauthorityGreaterThanOrEqualTo(String value) {
            addCriterion("userAuthority >=", value, "userauthority");
            return (Criteria) this;
        }

        public Criteria andUserauthorityLessThan(String value) {
            addCriterion("userAuthority <", value, "userauthority");
            return (Criteria) this;
        }

        public Criteria andUserauthorityLessThanOrEqualTo(String value) {
            addCriterion("userAuthority <=", value, "userauthority");
            return (Criteria) this;
        }

        public Criteria andUserauthorityLike(String value) {
            addCriterion("userAuthority like", value, "userauthority");
            return (Criteria) this;
        }

        public Criteria andUserauthorityNotLike(String value) {
            addCriterion("userAuthority not like", value, "userauthority");
            return (Criteria) this;
        }

        public Criteria andUserauthorityIn(List<String> values) {
            addCriterion("userAuthority in", values, "userauthority");
            return (Criteria) this;
        }

        public Criteria andUserauthorityNotIn(List<String> values) {
            addCriterion("userAuthority not in", values, "userauthority");
            return (Criteria) this;
        }

        public Criteria andUserauthorityBetween(String value1, String value2) {
            addCriterion("userAuthority between", value1, value2, "userauthority");
            return (Criteria) this;
        }

        public Criteria andUserauthorityNotBetween(String value1, String value2) {
            addCriterion("userAuthority not between", value1, value2, "userauthority");
            return (Criteria) this;
        }

        public Criteria andUsergenderIsNull() {
            addCriterion("userGender is null");
            return (Criteria) this;
        }

        public Criteria andUsergenderIsNotNull() {
            addCriterion("userGender is not null");
            return (Criteria) this;
        }

        public Criteria andUsergenderEqualTo(String value) {
            addCriterion("userGender =", value, "usergender");
            return (Criteria) this;
        }

        public Criteria andUsergenderNotEqualTo(String value) {
            addCriterion("userGender <>", value, "usergender");
            return (Criteria) this;
        }

        public Criteria andUsergenderGreaterThan(String value) {
            addCriterion("userGender >", value, "usergender");
            return (Criteria) this;
        }

        public Criteria andUsergenderGreaterThanOrEqualTo(String value) {
            addCriterion("userGender >=", value, "usergender");
            return (Criteria) this;
        }

        public Criteria andUsergenderLessThan(String value) {
            addCriterion("userGender <", value, "usergender");
            return (Criteria) this;
        }

        public Criteria andUsergenderLessThanOrEqualTo(String value) {
            addCriterion("userGender <=", value, "usergender");
            return (Criteria) this;
        }

        public Criteria andUsergenderLike(String value) {
            addCriterion("userGender like", value, "usergender");
            return (Criteria) this;
        }

        public Criteria andUsergenderNotLike(String value) {
            addCriterion("userGender not like", value, "usergender");
            return (Criteria) this;
        }

        public Criteria andUsergenderIn(List<String> values) {
            addCriterion("userGender in", values, "usergender");
            return (Criteria) this;
        }

        public Criteria andUsergenderNotIn(List<String> values) {
            addCriterion("userGender not in", values, "usergender");
            return (Criteria) this;
        }

        public Criteria andUsergenderBetween(String value1, String value2) {
            addCriterion("userGender between", value1, value2, "usergender");
            return (Criteria) this;
        }

        public Criteria andUsergenderNotBetween(String value1, String value2) {
            addCriterion("userGender not between", value1, value2, "usergender");
            return (Criteria) this;
        }

        public Criteria andUseridcardIsNull() {
            addCriterion("userIdCard is null");
            return (Criteria) this;
        }

        public Criteria andUseridcardIsNotNull() {
            addCriterion("userIdCard is not null");
            return (Criteria) this;
        }

        public Criteria andUseridcardEqualTo(String value) {
            addCriterion("userIdCard =", value, "useridcard");
            return (Criteria) this;
        }

        public Criteria andUseridcardNotEqualTo(String value) {
            addCriterion("userIdCard <>", value, "useridcard");
            return (Criteria) this;
        }

        public Criteria andUseridcardGreaterThan(String value) {
            addCriterion("userIdCard >", value, "useridcard");
            return (Criteria) this;
        }

        public Criteria andUseridcardGreaterThanOrEqualTo(String value) {
            addCriterion("userIdCard >=", value, "useridcard");
            return (Criteria) this;
        }

        public Criteria andUseridcardLessThan(String value) {
            addCriterion("userIdCard <", value, "useridcard");
            return (Criteria) this;
        }

        public Criteria andUseridcardLessThanOrEqualTo(String value) {
            addCriterion("userIdCard <=", value, "useridcard");
            return (Criteria) this;
        }

        public Criteria andUseridcardLike(String value) {
            addCriterion("userIdCard like", value, "useridcard");
            return (Criteria) this;
        }

        public Criteria andUseridcardNotLike(String value) {
            addCriterion("userIdCard not like", value, "useridcard");
            return (Criteria) this;
        }

        public Criteria andUseridcardIn(List<String> values) {
            addCriterion("userIdCard in", values, "useridcard");
            return (Criteria) this;
        }

        public Criteria andUseridcardNotIn(List<String> values) {
            addCriterion("userIdCard not in", values, "useridcard");
            return (Criteria) this;
        }

        public Criteria andUseridcardBetween(String value1, String value2) {
            addCriterion("userIdCard between", value1, value2, "useridcard");
            return (Criteria) this;
        }

        public Criteria andUseridcardNotBetween(String value1, String value2) {
            addCriterion("userIdCard not between", value1, value2, "useridcard");
            return (Criteria) this;
        }

        public Criteria andUseridcardtypeIsNull() {
            addCriterion("userIdCardType is null");
            return (Criteria) this;
        }

        public Criteria andUseridcardtypeIsNotNull() {
            addCriterion("userIdCardType is not null");
            return (Criteria) this;
        }

        public Criteria andUseridcardtypeEqualTo(String value) {
            addCriterion("userIdCardType =", value, "useridcardtype");
            return (Criteria) this;
        }

        public Criteria andUseridcardtypeNotEqualTo(String value) {
            addCriterion("userIdCardType <>", value, "useridcardtype");
            return (Criteria) this;
        }

        public Criteria andUseridcardtypeGreaterThan(String value) {
            addCriterion("userIdCardType >", value, "useridcardtype");
            return (Criteria) this;
        }

        public Criteria andUseridcardtypeGreaterThanOrEqualTo(String value) {
            addCriterion("userIdCardType >=", value, "useridcardtype");
            return (Criteria) this;
        }

        public Criteria andUseridcardtypeLessThan(String value) {
            addCriterion("userIdCardType <", value, "useridcardtype");
            return (Criteria) this;
        }

        public Criteria andUseridcardtypeLessThanOrEqualTo(String value) {
            addCriterion("userIdCardType <=", value, "useridcardtype");
            return (Criteria) this;
        }

        public Criteria andUseridcardtypeLike(String value) {
            addCriterion("userIdCardType like", value, "useridcardtype");
            return (Criteria) this;
        }

        public Criteria andUseridcardtypeNotLike(String value) {
            addCriterion("userIdCardType not like", value, "useridcardtype");
            return (Criteria) this;
        }

        public Criteria andUseridcardtypeIn(List<String> values) {
            addCriterion("userIdCardType in", values, "useridcardtype");
            return (Criteria) this;
        }

        public Criteria andUseridcardtypeNotIn(List<String> values) {
            addCriterion("userIdCardType not in", values, "useridcardtype");
            return (Criteria) this;
        }

        public Criteria andUseridcardtypeBetween(String value1, String value2) {
            addCriterion("userIdCardType between", value1, value2, "useridcardtype");
            return (Criteria) this;
        }

        public Criteria andUseridcardtypeNotBetween(String value1, String value2) {
            addCriterion("userIdCardType not between", value1, value2, "useridcardtype");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table USER_NEU
     *
     * @mbggenerated do_not_delete_during_merge Sun Jul 30 22:26:32 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table USER_NEU
     *
     * @mbggenerated Sun Jul 30 22:26:32 CST 2017
     */
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