package wyd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wyd.dto.User;

@Service("memoryAcmService")
public class MemoryAcmService implements AcmService {

	@Autowired
	private User rootUser;

	public void setRootUser(User rootUser) {
		this.rootUser = rootUser;
	}

	@Override
	public User authenticate(final String userId, final String password)
			throws InvalidCredentialException {

		if (!userId.equals(rootUser.getId())) {
			throw new InvalidCredentialException("Invalid UserId/Password...");
		}
		if (!password.equals(rootUser.getPassword())) {
			throw new InvalidCredentialException("Invalid UserId/Password...");
		}

		return rootUser;
	}

	@Override
	public void logout(final String userId) {
	}
}
