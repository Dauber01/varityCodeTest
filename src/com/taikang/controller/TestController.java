package com.taikang.controller;

public class TestController {

	@RequestMapping("/getCode.do")
    public void getCode(HttpServletRequest reqeust, HttpServletResponse response) throws IOException {

        response.setContentType("image/jpeg");
        // ½ûÖ¹Í¼Ïñ»º´æ¡£
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        HttpSession session = reqeust.getSession();

        ValidateCode vCode = new ValidateCode(100, 28, 4, 100);
        session.setAttribute(Helper.SESSION_CHECKCODE, vCode.getCode());
        vCode.write(response.getOutputStream());
    }
}
