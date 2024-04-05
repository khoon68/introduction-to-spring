package springreact.aa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import springreact.aa.domain.Member;
import springreact.aa.service.MemberService;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createMemberForm() {
        return "members/create-member-form";
    }

    @PostMapping("/members/new")
    public String joinMember(MemberForm memberForm) {
        Member member = new Member();
        member.setName(memberForm.getName());
        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String showMemberList(Model model) {
        model.addAttribute("members", memberService.findAll());

        return "/members/memberList";
    }
}
