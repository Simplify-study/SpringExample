package com.jonghun.example.e04;

import java.util.List;

import com.jonghun.example.e05.service.Member;

public interface UserMapper {

	public Member readUser(String username);

	public List<String> readAuthority(String username);

}
