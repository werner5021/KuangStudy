<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/jsp/common/head.jsp" %>
<div class="right">
    <div class="location">
        <strong>你現在所在的位置是:</strong>
        <span>密碼修改頁面</span>
    </div>
    <div class="providerAdd">
        <form id="userForm" name="userForm" method="post" action="${pageContext.request.contextPath }/jsp/user.do">
            <input type="hidden" name="method" value="savepwd"/>
            <!--div的class 为error是验证错误，ok是验证成功-->
            <div class="info">${message}</div>
            <div class="">
                <label for="oldPassword">舊密碼：</label>
                <input type="password" name="oldpassword" id="oldpassword" value="">
                <font color="red"></font>
            </div>
            <div>
                <label for="newPassword">新密碼：</label>
                <input type="password" name="newpassword" id="newpassword" value="">
                <font color="red"></font>
            </div>
            <div>
                <label for="newPassword">確認新密碼：</label>
                <input type="password" name="rnewpassword" id="rnewpassword" value="">
                <font color="red"></font>
            </div>
            <div class="providerAddBtn">
                <!--<a href="#">保存</a>-->
                <input type="button" name="save" id="save" value="保存" class="input-button">
            </div>
        </form>
    </div>
</div>
</section>
<%@include file="/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/pwdmodify.js"></script>