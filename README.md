# SiGan

##일별 작업 내용
5/27 Maven 프로젝트 생성 (Eclipse 에서 Dynamic Web Project 생성)
그 후 pom.xml 의 dependency 를 통해 스프링, 자바메일 전송, 톰켓 의존성 주입 완료

EmailSender.java 를 logic 패키지에 생성 완료
EmailSender 구현 완료


-5/28 
Main.java에 현재 시간 비교하고 이메일 보내는 로직 구현 완료, DataBaseInfo 모델 클래스 생성
그 후 mySQL을 통해 userTable(유저정보관리) postTable(게시글관리) 테이블 생성 완료

-5/29 
sql에 접근하여 List 를 생성 후, 각 post 의 정보를 List에 저장하는 로직 구현(Main.java에 구현)
그 후 DB에서 정보를 가져온 후 현재시간과 비교하여 시간이 일치하면 메일로 내용을 보내는 로직 구현 (Main.java)
- 메일 전송 관련 핵심기능 구현 완료

-5/30 
이전 방식으론 recipient 를 기본키로 사용하므로 한 이메일로 여러 post 작성하는것이 불가능 함 . -> 
USER정보를 관리할 필요가 없다고 판단, userTable을 삭제하고 postTable 로 통일
postTable의 모델클래스인 EmailInfo.java 파일 생성
모든 기능 정상 작동 확인 -> 추후 시간 형태를 yyyy-MM-dd hh:mm 으로 수정해야 할듯.

-5/31 ~ 6/5 
데스크탑에서 작업 후 commit 하지 않아서 작업 불가 ..

-6/11
6/11 index 홈페이지 디자인 완료, 
추후 write.jsp 만 구현하고, 모든 코드를 Spring 형식(모델, 컨테이너, 컨트롤 등.) 으로 변경하면 완료

-6/12
6/12 스프링으로 전환시 logic 패키지를 model 패키지로 이동하고, container, controller 패키지 생성, 
JDBC관리를 connection.DriverManager가 아닌 DataSource 를 사용해야 함을 파악

-6/13
6/13 write.jsp 의 디자인( writeCopy.jsp 에 작성) 구현 -> cols 속성을 변경하면 가운데 정렬 안되는 문제 발견
추가적으로 form 태그 action 수정, java코드에서 jsp 로 데이터가져오는법 알아야 할듯

-6/14 ~ 6/15
Spring 형태로 수정하는 작업 완료. (Controller 의 Bean 객체를 생성하는것을 까먹지 말것..)
Main.java 클래스를 run() 메소드로 새로 만들어 index.jsp 의 백그라운드에 계속 실행되도록 변경하기 전 작업임

-6/15 
SiGan 구현 완료. 모든 테스트 후  정상 작동 확인