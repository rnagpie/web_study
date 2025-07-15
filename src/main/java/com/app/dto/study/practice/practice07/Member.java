/*package com.app.dto.study.practice.practice07;


public class Member {
    private String id;
    private String pw;
    private String name;

    // 기본 생성자 (선택 사항이지만, 객체 생성 시 유용합니다)
    public Member() {}

    // 모든 필드를 초기화하는 생성자 (데이터 주입에 편리합니다)
    public Member(String id, String pw, String name) {
        this.id = id;
        this.pw = pw;
        this.name = name;
    }

    // Getter와 Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 객체 내용을 쉽게 확인하기 위한 toString() 메서드 (선택 사항)
    @Override
    public String toString() {
        return "Member [id=" + id + ", pw=" + pw + ", name=" + name + "]";
    }
}
*/


package com.app.dto.study.practice.practice07;

public class Member {
	String id;
	String pw;
	String name;
	
	public Member() {}
	
	public Member(String id, String pw, String name) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}