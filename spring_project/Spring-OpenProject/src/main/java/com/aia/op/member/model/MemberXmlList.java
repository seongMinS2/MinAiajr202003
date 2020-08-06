package com.aia.op.member.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "member-list")
public class MemberXmlList {
	
	@XmlElement(name = "member") // <member> ..... </member>
	private List<MemberXml> members;

	public MemberXmlList() {}
	
	public MemberXmlList(List<MemberXml> members) {
		this.members = members;
	}

	public List<MemberXml> getMembers() {
		return members;
	}

	public void setMembers(List<MemberXml> members) {
		this.members = members;
	}
	
	
}
