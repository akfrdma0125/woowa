package com.woowahan.prac.woowa_clone.menu;

import com.woowahan.prac.woowa_clone.members.RoleType;
import com.woowahan.prac.woowa_clone.members.dto.PatchMemberByPwReq;
import com.woowahan.prac.woowa_clone.members.dto.PostMemberRes;
import com.woowahan.prac.woowa_clone.menu.dto.GetMenuRes;
import com.woowahan.prac.woowa_clone.menu.dto.PatchMenuStateReq;
import com.woowahan.prac.woowa_clone.menu.dto.PostMenuReq;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class MenuRepository {
    private final JdbcTemplate jdbcTemplate;

    public MenuRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<GetMenuRes> selectById(Long storeid) {
        String findAllQuery =
                "select store_id,menu_name,soldout " +
                        "from menu where store_id=?;";

        Object[] findQueryParams = new Object[]{(storeid)};
        //람다식
        return this.jdbcTemplate.query(findAllQuery,
                (rs, rowNum) -> new GetMenuRes(
                        rs.getLong("store_id"),
                        rs.getString("menu_name"),
                        rs.getInt("soldout")),
                findQueryParams
        );
    }

    public List<GetMenuRes> selectAll() {
        String findAllQuery =
                "select store_id,menu_name,soldout " +
                        "from menu order by store_id;";

        //람다식
        return this.jdbcTemplate.query(findAllQuery,
                (rs, rowNum) -> new GetMenuRes(
                        rs.getLong("store_id"),
                        rs.getString("menu_name"),
                        rs.getInt("soldout"))
                );
    }

    public String insertMenu(PostMenuReq postMenuReq) {
        String joinQuery = "insert into menu(store_id, menu_name, soldout) values(?,?,?);";
        Object[] joinQueryParams = new Object[]{postMenuReq.getStoreid(), postMenuReq.getMenuname(), postMenuReq.getSoldout()};

        this.jdbcTemplate.update(joinQuery, joinQueryParams);

        Long MenuId = jdbcTemplate.queryForObject("select last_insert_id();",Long.class);

        return MenuId.toString();
    }

    public String updateMenuState(PatchMenuStateReq patchMenuStateReq) {
        String updateQuery =
                "update menu " +
                        "set soldout = ?" +
                        "where menuname like ? and store_id like ?;";

        Object[] updateQueryParams = new Object[]{patchMenuStateReq.getSoldout(), patchMenuStateReq.getMenuname(), patchMenuStateReq.getStoreid()};
        int tuple = this.jdbcTemplate.update(updateQuery,updateQueryParams);

        if(tuple > 0)
            return "success";
        else
            return "fail";

    }

}
