package wyd.service;

import wyd.dto.User;

public interface AcmService {

	public User authenticate(String userId, String password)
			throws InvalidCredentialException;

	public void logout(String userId);

}
