package com.ids.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ids.dto.UserDto;
import com.ids.entity.User;
import com.ids.mapper.UserMapper;
import com.ids.repository.UserRepository;
import com.ids.security.TokenProvider;
import com.ids.support.exception.BadRequestException;

import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
//	@Autowired
//	private MailService mailService;
	
	@Autowired
	private TokenProvider tokenProvider;
	
	private String hashPassword(String password) {
		return passwordEncoder.encode(password);
	}
	
	public User create(UserDto userDto) {
		if (userRepository.findByUsername(userDto.getUsername()).isPresent()) {
			log.warn("Nom d'utilisateur deja utilisé");
			throw new BadRequestException("username.exists");			
		}
		if (userRepository.findByEmail(userDto.getEmail()).isPresent()) {
			log.warn("Email deja utilisé");
			throw new BadRequestException("email.exists");			
		}
		User user = UserMapper.INSTANCE.dtoToUser(userDto);
		user.setPassword(hashPassword(userDto.getPassword()));
		user = userRepository.save(user);
		sendMailActivation(user);
		return user;
	}
	
	@Transactional
	public void activate(String token) {
		try {
			log.debug("Activation user with token : {}", token);
			Claims claims = tokenProvider.parse(token);
			String username = claims.getSubject();
			log.debug("Extracted username : {}", username);
			userRepository.findByUsername(username).map(user -> {
				log.debug("activate user : {}", username);
				user.setActivated(true);
				userRepository.save(user);
				return user;
			}).orElseThrow(() -> new BadRequestException("Utilisateur n'existe pas"));
		} catch (Exception e) {
			throw new BadRequestException("Votre token est invalide ou expiré");
		}
	}

//	public String resetPasswordInit(String email) {
//		return userRepository.findByEmail(email).map(user -> {
//			Map<String, Object> claims = new HashMap<>();
//			claims.put("ACT", "RP");
//			String key = tokenProvider.createToken(
//					email,
//					DateUtils.add(new Date(), 120L),
//					claims
//			);
//			// persist token
//			sendMailResetPassword(user, key);
//			return key;
//		}).orElseThrow(() -> new BadRequestException("Adresse mail n'existe pas"));
//	}
//
//	public void resetPasswordFinish(ResetPasswordDto dto) {
//		try {
//			log.debug("Activation user with token : {}", dto.getKey());
//			// get token form table
//			Claims claims = tokenProvider.parse(dto.getKey());
//			String email = claims.getSubject();
//			log.debug("Extracted email : {}", email);
//			userRepository.findByEmail(email).map(user -> {
//				log.debug("reset user password : {}", email);
//				user.setPassword(hashPassword(dto.getPassword()));
//				user.setActivated(true);
//				userRepository.save(user);
//				//delete token form table
//				return user;
//			}).orElseThrow(() -> new BadRequestException("Utilisateur n'existe pas"));
//		} catch (Exception e) {
//			throw new BadRequestException("Votre token est invalide ou expiré");
//		}
//	}

	private void sendMailActivation(User user) {
//		String key = tokenProvider.createToken(
//				user.getUsername(),
//				DateUtils.add(new Date(), 120L),
//				null
//		);
//		Map<String, Object> model = new HashMap<>();
//		model.put("user", user);
//		model.put("key", key);
//		Mail mail = Mail.builder()
//					.to(user.getEmail())
//					.subject("Validation du compte")
//					.templateName("mail/activationEmail")
//					.model(model)
//					.build();
//		mailService.sendEmailFromTemplate(mail);
	}

	private void sendMailResetPassword(User user, String key) {
		
//		Map<String, Object> model = new HashMap<>();
//		model.put("user", user);
//		model.put("key", key);
//		Mail mail = Mail.builder()
//					.to(user.getEmail())
//					.subject("Réinitialisation du mot de passe")
//					.templateName("mail/passwordResetEmail")
//					.model(model)
//					.build();
//		mailService.sendEmailFromTemplate(mail);
	}


}
