package br.com.fiap.gs2.network

import br.com.fiap.gs2.model.LoginRequest
import br.com.fiap.gs2.model.Usuario
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UsuarioApi {
    @POST("usuario/create-usuario")
    fun criarUsuario(@Body usuario: Usuario): Call<Usuario>

    @POST("usuario/login")
    fun loginUsuario(@Body loginRequest: LoginRequest): Call<Usuario>
}
