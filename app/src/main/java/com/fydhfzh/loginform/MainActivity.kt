package com.fydhfzh.loginform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fydhfzh.loginform.ui.theme.LoginFormTheme
import com.fydhfzh.loginform.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginFormTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginForm()
                }
            }
        }
    }
}

@Composable
fun CompanyLogo(modifier: Modifier = Modifier){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFFFF0000),
                shape = RoundedCornerShape(bottomEnd = 100.dp, bottomStart = 100.dp)
            )
            .padding(horizontal = 40.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ){
        Image(
            painter = painterResource(id = R.drawable.subtract__1_),
            contentDescription = "Company Logo",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(75.dp))
        Text(
            text = "Welcome Back",
            style = TextStyle(Color(0xfff5f5f5)),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
            )
    }
}

@Composable
fun LoginField(modifier: Modifier = Modifier){
    var password by rememberSaveable {
        mutableStateOf("")
    }
    var email by rememberSaveable {
        mutableStateOf("")
    }
    val maxLength = 30

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Login to your account",
            modifier = modifier.padding(horizontal = 10.dp, vertical = 10.dp),
            fontSize = 20.sp,
            color = Color.DarkGray
        )
        Spacer(modifier = modifier.height(20.dp))
        OutlinedTextField(value = email, onValueChange = { if (it.length <= maxLength) email = it }, maxLines = 1, label = {
            Text(text = "Email Address")
        })
        Spacer(modifier = modifier.height(20.dp))
        OutlinedTextField(value = password, onValueChange = { if (it.length <= maxLength) password = it }, maxLines = 1,  visualTransformation = PasswordVisualTransformation(), label = {
            Text(text = "Password")
        })
        Spacer(modifier = modifier.height(20.dp))
        Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
            containerColor = Red10
        )) {
            Text(
                text = "Login",
                fontSize = 15.sp
            )
        }
        Spacer(modifier = modifier.height(10.dp))
        Text(
            text = "Forgot your password?",
            color = Color.DarkGray
        )
        Spacer(modifier = modifier.height(60.dp))
    }
}

@Composable
fun OAuthLoginField(modifier: Modifier = Modifier){
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "or sign in with",
                color = Color.DarkGray
            )
            Spacer(modifier = modifier.height(20.dp))
            Row(
                modifier = modifier
                    .fillMaxWidth(0.6f),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(painter = painterResource(id = R.drawable.icons8_facebook_96), contentDescription = "Facebook Auth", Modifier.size(60.dp))
                Image(painter = painterResource(id = R.drawable.icons8_google_96), contentDescription = "Google Auth", Modifier.size(60.dp))
                Image(painter = painterResource(id = R.drawable.icons8_twitter_100), contentDescription = "X Auth", Modifier.size(60.dp))
            }
        }
    }
}

@Composable
fun LoginForm(modifier: Modifier = Modifier){
    Column(
        modifier = modifier
    ) {
        CompanyLogo(modifier = modifier.height(200.dp))
        LoginField(modifier = modifier)
        OAuthLoginField(modifier = modifier)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginFormPreview() {
    LoginFormTheme {
        LoginForm()
    }
}