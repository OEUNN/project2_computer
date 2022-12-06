<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="/WEB-INF/views/common/header1.jsp" %>
<link rel="stylesheet" href="../resources/css/header.css">
<link rel="stylesheet" href="../resources/css/qnaBoard.css">
<script>
	function qnaUpdate(num=1){
		/* console.log(num); */
		<c:forEach var="qnaBoard" items="${qnaList }" varStatus="status">
			/*선택한 행 게시물일때 게시물값을 넣는다*/
			if(${status.index}==num){
				
				$("#qnaUpdate form #title").attr("value","${qnaBoard.qnaBtitle}");
				$("#qnaUpdate form textarea").text("${qnaBoard.qnaBcontent}");
				$("#qnaUpdate form #bno").attr("value","${qnaBoard.qnaBno}");
				
			}
		</c:forEach>
	}
	function qnaDelete(num){
		<c:forEach var="qnaBoard" items="${qnaList }" varStatus="status">
		/*선택한 행 게시물일때 게시물값을 넣는다*/
		if(${status.index}==num){
			
			$("#qnaDelete form #bno").attr("value","${qnaBoard.qnaBno}");
			
		}
	</c:forEach>
		
	}
</script>
<%@ include file="/WEB-INF/views/common/header2.jsp" %>
<%@ include file="/WEB-INF/views/common/mypageMenu.jsp" %>

<!-- 1대1문의 내역 -->
<div id="centerBoard" class="col-12 col-md mt-5">
	<div class="container-fluid">
		<div id="centerText" class="row mt-5 ml-3">1:1 문의</div>

		<!-- 빈공간 -->
	<div class="row m-3"></div>

	<!-- 버튼 -->
	<div id="contentButton" class="row m-3">
		<button class="btn btn-#0c1c32 btn-dark rounded-1"
			style="width: 100%;" data-toggle="modal" data-target="#qnaModal">문의하기</button>
	</div>

	<!-- 빈공간 -->
	<div class="row m-3"></div>

	<!-- 문의글 -->
	<div id="contentText" class="row m-3">
		<div id="contentBox" class="container-fluid p-5">
			<c:forEach var="qnaBoard" items="${qnaList }" varStatus="status">
				<div id="qnaList" class="qnaList row m-1">
					<div id="qnaNum" class="col-1">
						<!-- <i class="btn fas" >&#xf00d;</i> -->
						${status.count}
					</div>
					<div class="col-11 qnaTitle">
						<a href="#qnaDetail${status.count}" data-toggle="collapse">${qnaBoard.qnaBtitle }<span></span></a>
						<p>
							작성일자<span>${qnaBoard.qnaDate }</span>
						</p>
					</div>
					<div class="col-1 qnaDetail collapse"
						id="qnaDetail${status.count}">
						<br />질문내용
					</div>
					<div class="qnaDetail collapse col-11"
						id="qnaDetail${status.count}">
						<hr />
						<p>${qnaBoard.qnaBcontent }</p>
						<hr />
						<div class="row">

							<div class="col-8">
								<p>답변내용이 들어갈 위치입니다.</p>
							</div>
							<div class="col-2">
								<button class="btn btn-#0c1c32 btn-dark btn-sm" onclick="qnaUpdate(${status.index})" data-toggle="modal" data-target="#qnaUpdate">수정</button>
								<button class="btn btn-#0c1c32 btn-dark btn-sm" onclick="qnaDelete(${status.index})" data-toggle="modal" data-target="#qnaDelete">삭제</button>

							</div>
						</div>
					</div>

				</div>
			</c:forEach>
			<div style="text-align: center">
				<a href="QnaBoardController?pageNo=1"
					class="btn btn-outline-primary btn-sm pagerBtn">처음</a>
				<c:if test="${pager.groupNo>1 }">
					<a href="QnaBoardController?pageNo=1"
						class="btn btn-outline-info btn-sm pagerBtn">이전</a>
				</c:if>
				<c:forEach var="i" begin="${pager.startPageNo }"
					end="${pager.endPageNo}">
					<c:if test="${pager.pageNo !=i }">
						<a href="QnaBoardController?pageNo=${i}"
							class="btn btn-outline-success btn-sm pagerBtn">${i}</a>
					</c:if>
					<c:if test="${pager.pageNo==i }">
						<a href="QnaBoardController?pageNo=${i}"
							style="background-color: #e0e0e0"
							class="btn btn-danger btn-sm pagerBtn">${i}</a>
					</c:if>
				</c:forEach>
				<c:if test="${pager.groupNo<pager.totalGroupNo }">
					<a href="QnaBoardController?pageNo=${i}"
						class="btn btn-outline-info btn-sm pagerBtn">다음</a>
				</c:if>
				<a href="QnaBoardController?pageNo=${pager.totalPageNo}"
						class="btn btn-outline-primary btn-sm pagerBtn">맨끝</a>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="col-0 col-md-1 "></div>
</div>
</div>



<!-- The Modal -->
<div class="modal fade" id="qnaModal">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">

			<!-- Modal Header -->
			<div class="modal-header">
				<h4 class="modal-title">1:1 문의 작성</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
	
			<!-- Modal body -->
			<div class="modal-body">
	
	
				<form method="Post" action="QnaBoardWriteController"
					id="qnaBoardWrite">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="제목을 입력해주세요"
							id="title" name="title">
					</div>
	
					<div class="form-group" style="height: 100%">
						<textarea style="height: 300px; width: 100%" name="inquiryContent"
							id="inquiryContent" placeholder="리뷰 내용을 입력해 주세요. (500자 이내)"></textarea>
					</div>
	
	
				</form>
	
			</div>
	
			<!-- Modal footer -->
			<div class="modal-footer">
				<button type="submit" form="qnaBoardWrite" class="btn btn-secondary">등록</button>
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
	
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="qnaUpdate">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">

			<!-- Modal Header -->
			<div class="modal-header">
				<h4 class="modal-title">1:1 문의 수정</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
	
			<!-- Modal body -->
			<div class="modal-body">
	
	
				<form method="Post" action="QnaBoardUpdateController"
					id="qnaBoardUpdate">
					<div class="form-group">
						<input type="text" class="form-control" value=""
							id="title" name="title">
					</div>
	
					<div class="form-group" style="height: 100%">
						<textarea style="height: 300px; width: 100%" name="inquiryContent"
							id="inquiryContent" ></textarea>
					</div>
					<input class="form-group" style="display:none" id="bno" name="bno" type="text" value="">
					
				</form>
	
			</div>
	
			<!-- Modal footer -->
			<div class="modal-footer">
				<button type="submit" form="qnaBoardUpdate" class="btn btn-secondary">수정완료</button>
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
	
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="qnaDelete">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">

			<!-- Modal Header -->
			<div class="modal-header">
				<h4 class="modal-title">정말로 삭제하시겠습니까?</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
	
			
	
	
				<form method="Post" action="QnaBoardDeleteController"
					id="qnaBoardDelete">
					
					<input class="form-group" style="display:none" id="bno" name="bno" type="text" value="">
	
				</form>
	
			
	
			<!-- Modal footer -->
			<div class="modal-footer">
				<button type="submit" form="qnaBoardDelete" class="btn btn-secondary">예</button>
				<button type="button" class="btn btn-secondary" data-dismiss="modal">아니오</button>
	
			</div>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>