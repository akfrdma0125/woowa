package com.woowahan.prac.woowa_clone.menu;

import com.woowahan.prac.woowa_clone.members.dto.PostMemberRes;
import com.woowahan.prac.woowa_clone.menu.dto.GetMenuById;
import com.woowahan.prac.woowa_clone.menu.dto.GetMenuRes;
import com.woowahan.prac.woowa_clone.menu.dto.PatchMenuStateReq;
import com.woowahan.prac.woowa_clone.menu.dto.PostMenuReq;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/menu")
public class MenuController {
    private final MenuService menuService;
    private final MenuRepository menuRepository;

    @GetMapping("")
    public List<GetMenuRes> findAll() {
        return menuRepository.selectAll();
    }

    @GetMapping("/info")
    public List<GetMenuRes> findByName(@RequestBody GetMenuById getMenuById) {
        return menuRepository.selectById(getMenuById.getStoreid());
    }
    //가게만 가능했으면 좋겠음 service에서 role확인을 할지?
    @PostMapping("/signup")
    public String join(@RequestBody PostMenuReq postMenuReq) {
        return menuService.create(postMenuReq);
    }

    @PutMapping("/state")
    public String state(@RequestBody PatchMenuStateReq patchMenuStateReq) {
        return menuService.updateMenuState(patchMenuStateReq);
    }


}
