package com.example.service;


import com.example.Exception.NoValueException;
import com.example.vo.ActivateVo;
import com.example.vo.ListVo;
import com.example.vo.MemberVo;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MemberService {

    private List<MemberVo> memberData = new ArrayList<>();

    private int uid = 0;

    public List<ListVo> findListAll() throws NoValueException {

        List<ListVo> memberList = new ArrayList<>();

        if(memberData.size() == 0) {
            throw new NoValueException();
        }

        for (int i=0; i<memberData.size(); i++) {

            ListVo member = new ListVo();
            member.setUid(memberData.get(i).getUid());
            member.setName(memberData.get(i).getName());
            member.setPhone(memberData.get(i).getPhone());
            member.setEmail(memberData.get(i).getEmail());
            member.setEnable(memberData.get(i).getEnable());
            memberList.add(member);
        }

        return memberList;
    }

    public List<ListVo> findListPaging(int page) throws NoValueException {

        List<ListVo> memberList = new ArrayList<>();

        int target = 3 ;    //3건씩 출력

        int rangeMin = (target * page - (target - 1)) - 1;
        int rangeMax = (target * page) - 1;

        if(memberData.size() == 0) {
            throw new NoValueException();
        }

        for (int i=0; i<memberData.size(); i++) {

            if(i >= rangeMin &&
                    i <= rangeMax) {
                ListVo member = new ListVo();
                member.setUid(memberData.get(i).getUid());
                member.setName(memberData.get(i).getName());
                member.setPhone(memberData.get(i).getPhone());
                member.setEmail(memberData.get(i).getEmail());
                member.setEnable(memberData.get(i).getEnable());
                memberList.add(member);
            }

        }

        return memberList;
    }


    public List<ListVo> findEnable(int enable) throws NoValueException {

        List<ListVo> memberList = new ArrayList<>();

        if(memberData.size() == 0) {
            throw new NoValueException();
        }

        for (int i=0; i<memberData.size(); i++) {

            if(memberData.get(i).getEnable() == enable) {

                ListVo member = new ListVo();
                member.setUid(memberData.get(i).getUid());
                member.setName(memberData.get(i).getName());
                member.setPhone(memberData.get(i).getPhone());
                member.setEmail(memberData.get(i).getEmail());
                member.setEnable(memberData.get(i).getEnable());
                memberList.add(member);
            }
        }

        return memberList;
    }


    public MemberVo findByUid(int uid) throws NoValueException {        // Optional<T> 찾아보기

        for (int i=0; i<memberData.size(); i++) {
            if(memberData.get(i).getUid() == (uid)) {


                return memberData.get(i);
            }
        }


        throw new NoValueException();



    }

    public List<MemberVo> findByName(String name) throws Exception {

        List<MemberVo> findName = new ArrayList<>();
        //MemberVo memberVo = new MemberVo();

        if(memberData.size() == 0) {
            throw new NoValueException();
        }

        for (int i=0; i<memberData.size(); i++) {
            if(memberData.get(i).getName().equals(name)) {

                findName.add(memberData.get(i));

            }
        }
        if(findName.size() > 0) {
            return findName;
        }

        throw new NoValueException();
    }

    public MemberVo save (MemberVo memberVo) {

        memberVo.setUid(++uid);
        memberVo.setEnable(1);
        memberData.add(memberVo);

        return memberVo;
    }


    public MemberVo updateMemberData(int uid, MemberVo memberVo) throws Exception {

        if(memberData.size() == 0) {
            throw new NoValueException();
        }

        for (int i=0; i<memberData.size(); i++) {
            if(memberData.get(i).getUid() == (uid)) {

                if(memberVo.getName() != null) {
                    memberData.get(i).setName(memberVo.getName());
                } else {
                    memberData.get(i).setName(memberData.get(i).getName());
                }

                if(memberVo.getAge() != 0) {
                    memberData.get(i).setAge(memberVo.getAge());
                } else {
                    memberData.get(i).setAge(memberData.get(i).getAge());
                }

                if(memberVo.getAddress() != null) {
                    memberData.get(i).setAddress(memberVo.getAddress());
                } else {
                    memberData.get(i).setAddress(memberData.get(i).getAddress());
                }

                if(memberVo.getPhone() != null) {
                    memberData.get(i).setPhone(memberVo.getPhone());
                } else {
                    memberData.get(i).setPhone(memberData.get(i).getPhone());
                }

                if(memberVo.getEmail() != null) {
                    memberData.get(i).setEmail(memberVo.getEmail());
                } else {
                    memberData.get(i).setEmail(memberData.get(i).getEmail());
                }

                if(memberVo.getBirth() != null) {
                    memberData.get(i).setBirth(memberVo.getBirth());
                } else {
                    memberData.get(i).setBirth(memberData.get(i).getBirth());
                }

                return memberData.get(i);
            }
        }

        throw new NoValueException();
    }

    public List<MemberVo> updateActivate(List<ActivateVo> activateVo) throws Exception {

        List<MemberVo> resultData = new ArrayList<>();

        for (int i=0; i<memberData.size(); i++) {
            for(int j=0; j<activateVo.size(); j++) {
                if(memberData.get(i).getUid() == activateVo.get(j).getUid()) {
                    memberData.get(i).setEnable(activateVo.get(j).getEnable());

                    resultData.add(memberData.get(i));


                }
            }
        }


        if(resultData.size() > 0) {
            return resultData;
        }

        throw new NoValueException();
    }


    public String deleteByUid(int uid) {

        for (int i=0; i<memberData.size(); i++) {
            if(memberData.get(i).getUid() == (uid)) {

                memberData.remove(i);
            }
        }

        return "idx "+uid+" deleted";
    }


    public String deleteByActivate(List<ActivateVo> activateVo) {

        int cnt = 0;

        for (int i=0; i<memberData.size(); i++) {
            for(int j=0; j<activateVo.size(); j++) {
                if(memberData.get(i).getUid() == activateVo.get(j).getUid()) {

                    memberData.remove(i);
                    cnt++;
                }
            }
        }

        return cnt+" row deleted";
    }

}
