package br.com.credsystem.unico.facematchpoc.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.credsystem.unico.facematchpoc.application.service.FaceMatchJob;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/match")
@RequiredArgsConstructor
public class FaceMatchJobController {
	private final FaceMatchJob faceMatchJob;

	@PostMapping
	@ResponseStatus(code = HttpStatus.OK)
	public void fazerFaceMatch() {
		log.info("[inicia] FaceMatchJobController - fazerFaceMatch");
		faceMatchJob.executa();
		log.info("[finaliza] FaceMatchJobController - fazerFaceMatch");
	}
}