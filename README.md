# SiGan

5/27 Maven 프로젝트 생성 (Eclipse 에서 Dynamic Web Project 생성)
그 후 pom.xml 의 dependency 를 통해 스프링, 자바메일 전송, 톰켓 의존성 주입 완료

EmailSender.java 를 logic 패키지에 생성 완료
EmailSender 구현 완료


5/28 Main.java에 현재 시간 비교하고 이메일 보내는 로직 구현 완료, DataBaseInfo 모델 클래스 생성
그 후 mySQL을 통해 userTable(유저정보관리) postTable(게시글관리) 테이블 생성 완료

5/29 sql에 접근하여 List 를 생성 후, 각 post 의 정보를 List에 저장하는 로직 구현(Main.java에 구현)
그 후 DB에서 정보를 가져온 후 현재시간과 비교하여 시간이 일치하면 메일로 내용을 보내는 로직 구현 (Main.java)
- 메일 전송 관련 핵심기능 구현 완료

5/30 
이전 방식으론 recipient 를 기본키로 사용하므로 한 이메일로 여러 post 작성하는것이 불가능 함 . -> 
USER정보를 관리할 필요가 없다고 판단, userTable을 삭제하고 postTable 로 통일
postTable의 모델클래스인 EmailInfo.java 파일 생성
모든 기능 정상 작동 확인 -> 추후 시간 형태를 yyyy-MM-dd hh:mm 으로 수정해야 할듯.
