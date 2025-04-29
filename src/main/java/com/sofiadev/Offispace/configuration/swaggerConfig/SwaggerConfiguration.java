package com.sofiadev.Offispace.configuration.swaggerConfig;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@OpenAPIDefinition(
        info = @Info(
                title = "OffiSpace - Open Api Documentation",
                version = "1.0",
                description = "API REST para la gestión de reservas de espacios de reuniones, oficinas y eventos. Soporta operaciones CRUD para el administrador y los usuarios. " +
                        "\n\n 🔐 Login con JWT.\n" +
                        "\n 👤 Roles: USER y ADMIN.\n" +
                        "\n 📁 [Repositorio en GitHub](https://github.com/SofiaJuego/OffiSpace)"
        ),
        security = {
                @SecurityRequirement(name = "bearerAuth")
        }
)
@SecurityScheme(
        name = "bearerAuth",
        description = "JWT authentication",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class SwaggerConfiguration {
}
