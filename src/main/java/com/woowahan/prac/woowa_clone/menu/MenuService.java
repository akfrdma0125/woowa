package com.woowahan.prac.woowa_clone.menu;

import com.woowahan.prac.woowa_clone.members.dto.PostMemberRes;
import com.woowahan.prac.woowa_clone.menu.dto.PatchMenuStateReq;
import com.woowahan.prac.woowa_clone.menu.dto.PostMenuReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;

    public String create(PostMenuReq postMenuReq) {
        int check= postMenuReq.getSoldout();
        if (check == 0 || check == 1)
            return menuRepository.insertMenu(postMenuReq);
        else
            return "error";
    }

    public String updateMenuState(PatchMenuStateReq patchMenuStateReq){
        int check=patchMenuStateReq.getSoldout();
        if (check == 0 || check == 1)
            return menuRepository.updateMenuState(patchMenuStateReq);
        else
            return "error";
    }
}
