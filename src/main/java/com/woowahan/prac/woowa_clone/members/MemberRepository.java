package com.woowahan.prac.woowa_clone.members;

import com.woowahan.prac.woowa_clone.members.dto.GetMemberByNamePwReq;
import com.woowahan.prac.woowa_clone.members.dto.GetMemberRes;
import com.woowahan.prac.woowa_clone.members.dto.PatchMemberByPwReq;
import com.woowahan.prac.woowa_clone.members.dto.PostMemberReq;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class MemberRepository {
    private final JdbcTemplate jdbcTemplate;
    /*
    Mybatis, .. 등 tool 존재
     */

    //필드 선언, application.yml에 입력한 정보와 connection, dataSource가 spring bean으로 만들어짐
    public MemberRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Long insert(PostMemberReq postMemberReq) {
        String joinQuery = "insert into member(member_name, email, password, role) values(?,?,?,?);";
        Object[] joinQueryParams = new Object[]{postMemberReq.getName(), postMemberReq.getEmail(), postMemberReq.getPassword(), postMemberReq.getRole().toString()};

        this.jdbcTemplate.update(joinQuery, joinQueryParams);

        Long memberId = jdbcTemplate.queryForObject("select last_insert_id();",Long.class);

        return memberId;
    }

    public List<GetMemberRes> selectAll() {
        String findAllQuery =
                "select member_id, email, member_name, role " +
                "from member;";

        //람다식
        return this.jdbcTemplate.query(findAllQuery,
                (rs, rowNum) -> new GetMemberRes(
                        rs.getLong("member_id"),
                        rs.getString("email"),
                        rs.getString("member_name"),
                        RoleType.toRoleType(rs.getString("role"))
                ));
    }

    public GetMemberRes selectByName(String memberName) {
        String findQuery =
                "select member_id, email, member_name, role " +
                "from member " +
                        "where member_name like ?;";

        Object[] findQueryParams = new Object[]{("%"+memberName+"%")};

        try {
            return this.jdbcTemplate.queryForObject(findQuery,findQueryParams,GetMemberRes.class);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public String selectByNamePw(GetMemberByNamePwReq getMemberByNamePwReq) {
        String findQuery =
                "select member_name " +
                        "from member " +
                        "where member_name like ? and password like ?;";

        Object[] findQueryParams = new Object[]{getMemberByNamePwReq.getName(),getMemberByNamePwReq.getPassword()};

        String name="아이디나 비밀 번호를 다시 확인해주세요";
        try {
            return this.jdbcTemplate.queryForObject(findQuery,findQueryParams,String.class);
        } catch (EmptyResultDataAccessException e) {
            return name;
        }
    }

    public String updatePw(PatchMemberByPwReq patchMemberByPwReq) {
        String updateQuery =
                "update member " +
                        "set password = ?, updated_at = ?" +
                        "where member_name like ? and password like ?;";

        Object[] updateQueryParams = new Object[]{patchMemberByPwReq.getNewPassword(),LocalDateTime.now(),patchMemberByPwReq.getName(),patchMemberByPwReq.getPassword()};
        int tuple = this.jdbcTemplate.update(updateQuery,updateQueryParams);

        if(tuple > 0)
            return "ok";
        else
            return "fail";

    }


}
