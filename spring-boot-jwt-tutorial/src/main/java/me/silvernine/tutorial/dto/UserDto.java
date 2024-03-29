package me.silvernine.tutorial.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import me.silvernine.tutorial.entity.User;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

   @NotNull
   @Size(min = 3, max = 50)
   private String username;

   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
   @NotNull
   @Size(min = 3, max = 100)
   private String password;

   @NotNull
   @Size(min = 3, max = 50)
   private String nickname;

   private Set<AuthorityDto> authorityDtoSet = new HashSet<>();

   public static UserDto from(User user) {
      if(user == null) return null;

      return UserDto.builder()
              .username(user.getAuthId())
              .nickname(user.getNickname())
              .authorityDtoSet(user.getAuthorities().stream()
                      .map(authority -> AuthorityDto.builder().authorityType(authority.getAuthorityType()).build())
                      .collect(Collectors.toSet()))
              .build();
   }
}