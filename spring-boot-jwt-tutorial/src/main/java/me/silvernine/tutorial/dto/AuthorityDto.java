package me.silvernine.tutorial.dto;

import lombok.*;
import me.silvernine.tutorial.entity.AuthorityType;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorityDto {
   private AuthorityType authorityType;
}