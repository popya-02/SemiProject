package com.gonggu.common;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

public class AlertMethod {
	public void returnAlert(HttpServletResponse response, String title, String msg, String icon, String url) throws IOException {
		response.getWriter().write("<script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@11\"></script>"
                 +"<script>"
                 +"    document.addEventListener('DOMContentLoaded', function() {"
                 +"        const cUrl = '" + url + "';"
                 +"        Swal.fire({"
                 +"            title: \"" + title + "\","
                 +"            text: \"" + msg + "\","
                 +"            icon: \"" + icon + "\","
                 +"        }).then(() => {"
                 +"            if(cUrl === ''){"
                 +"                window.history.back();"
                 +"            } else {"
                 +"                location.href = cUrl;"
                 +"            }"
                 +"        });"
                 +"    });"
                 +"</script>");
		// swal('타이틀', '내용', '아이콘'); 
		// success, error, warning, info, question
	}
}
