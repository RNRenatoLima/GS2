package br.com.fiap.gs2.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun UserListScreen(navController: NavHostController) {
    val users = listOf(
        User("João", "joao@email.com", "119999999", true),
        User("Maria", "email@email.com", "119999999", false),
        User("Pedro", "email@email.com", "119999999", true),
        User("Paulo", "email@email.com", "119999999", true),
        User("Igor", "email@email.com", "119999999", true)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(16.dp)
    ) {
        Text(text = "USUÁRIOS", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        users.forEach { user ->
            UserItem(user)
            Spacer(modifier = Modifier.height(8.dp))
        }
        FloatingActionButton(
            onClick = { navController.navigate("cadastroUsuario") },
            modifier = Modifier
                .align(Alignment.End)
                .padding(top = 16.dp)
        ) {
            Text("+")
        }
    }
}

@Composable
fun UserItem(user: User) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.elevatedCardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = user.name, fontSize = 18.sp)
                    Text(text = user.email, fontSize = 14.sp, color = Color.Gray)
                    Text(text = user.phone, fontSize = 14.sp, color = Color.Gray)
                }
                Button(
                    onClick = { /* TODO: Implement action */ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (user.isActive) Color.Green else Color.Red
                    )
                ) {
                    Text(text = if (user.isActive) "Ativo" else "Desativado", color = Color.White)
                }
            }
        }
    }
}

data class User(val name: String, val email: String, val phone: String, val isActive: Boolean)


/*
@Preview(showBackground = true)
@Composable
fun UserListScreenPreview() {
    UserListScreen()
}*/
