package com.example.controller;

import com.example.service.MemberService;
import com.example.vo.ActivateVo;
import com.example.vo.ListVo;
import com.example.vo.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.ws.server.endpoint.annotation.XPathParam;

import javax.validation.Valid;

import java.awt.*;
import java.util.List;

@RequestMapping("/member")
@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;



    @GetMapping("/list")
    public List<ListVo> findListAll() throws Exception {

        return memberService.findListAll();
    }

    @GetMapping(value = "/list", params = {"page"})
    public List<ListVo> findListPaging(@RequestParam(value = "page", required = false) int page) throws Exception {

        return memberService.findListPaging(page);
    }

    @GetMapping(value = "/list", params = {"enable"})
    public List<ListVo> findEnable(@RequestParam(value = "enable", required = false) int enable) throws Exception {

        return memberService.findEnable(enable);
    }

    @GetMapping("/{uid}")
    public MemberVo findByUid(@PathVariable("uid") int uid) throws Exception {

        return memberService.findByUid(uid);
    }


    @GetMapping("/find")
    public List<MemberVo> findByName(@RequestParam(value = "name",required = false) String name) throws Exception{

        return memberService.findByName(name);
    }


    @PostMapping("/save")
    public MemberVo save (@Valid @RequestBody MemberVo memberVo) {

        return memberService.save(memberVo) ;
    }



    @PutMapping("/update/{uid}")
    public MemberVo updateMemberData(@PathVariable() int uid, @Valid @RequestBody() MemberVo memberVo) throws Exception {


        return memberService.updateMemberData(uid, memberVo);
    }

    @PatchMapping("/activate")
    public List<MemberVo> updateActivate(@Valid @RequestBody() List<ActivateVo> activateVo) throws Exception {

        return memberService.updateActivate(activateVo);
    }


    @DeleteMapping("/delete/{uid}")
    public String deleteByIdx(@PathVariable("uid") int uid) {
        return memberService.deleteByUid(uid);
    }

    @DeleteMapping("/delete")
    public String deleteByActivate(@Valid @RequestBody() List<ActivateVo> activateVo) throws Exception {

        return memberService.deleteByActivate(activateVo);
    }
}
