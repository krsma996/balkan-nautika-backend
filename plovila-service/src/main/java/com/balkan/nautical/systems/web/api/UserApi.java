package com.balkan.nautical.systems.web.api;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;

import com.balkan.nautical.systems.dto.UserDto;
import com.balkan.nautical.systems.utils.ApiResponseCodeMessages;
import com.balkan.nautical.systems.utils.ApplicationConstants;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;





/*
 * 
 * @author Nikola Krsmanovic
 * User API main entry point
 *  
 */



@Validated
@Tag(name = ApplicationConstants.USER_API_TAG,  description = "The API for managing main User Account  ")
public interface UserApi {

	
	@Operation(summary = "Create user" , description = "Create user in locale DB and Keycloack")
	@ApiResponses(value = {
			@ApiResponse(responseCode = ApiResponseCodeMessages.CODE_200 , description = "OK", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserDto.class))),
			@ApiResponse(responseCode = ApiResponseCodeMessages.CODE_400,  description = "Bad request, invalid input or parameters", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserDto.class))),
	        @ApiResponse(responseCode = ApiResponseCodeMessages.CODE_403,  description = "Forbidden", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserDto.class))),
	        @ApiResponse(responseCode = ApiResponseCodeMessages.CODE_404,  description = "Resource not found, invalid key", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserDto.class))),
	        @ApiResponse(responseCode = ApiResponseCodeMessages.CODE_500,  description = "Internal error, something went wrong", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserDto.class))) })
	@PostMapping(value = "/users",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserDto> create(
            @Parameter(in = ParameterIn.DEFAULT, description = "User to create", required = false) @RequestBody(required = true) UserDto toCreate);
	
}
