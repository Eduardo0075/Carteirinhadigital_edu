package com.eduardosantos.carteirinhadigital2devest_b.feature.unidadecurriculares.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eduardosantos.carteirinhadigital2devest_b.feature.unidadecurriculares.domain.model.UnidadeCurricular

@Composable
fun UnidadeCurricularCard(
    modifier: Modifier = Modifier,
    unidadeCurricular: UnidadeCurricular
) {
    val mediaColor = if (unidadeCurricular.media >= 7.0) Color(0xFF007A5A) else Color(0xFFDC362E)

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = unidadeCurricular.nome,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Box(
                    modifier = Modifier
                        .background(
                            color = mediaColor.copy(alpha = 0.15f),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(horizontal = 10.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = "Média: ${unidadeCurricular.media}",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = mediaColor
                    )
                }
            }

            Text(
                text = "Professor: ${unidadeCurricular.professor}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.8f)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Nota 1: ${unidadeCurricular.nota1}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "Nota 2: ${unidadeCurricular.nota2}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "Faltas: ${unidadeCurricular.faltas}",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UnidadeCurricularCardPreview() {
    UnidadeCurricularCard(
        unidadeCurricular = UnidadeCurricular(
            id = "1",
            nome = "Matemática",
            professor = "Dr. Silva",
            nota1 = 8.5,
            nota2 = 7.0,
            media = 7.75,
            faltas = 2
        )
    )
}
