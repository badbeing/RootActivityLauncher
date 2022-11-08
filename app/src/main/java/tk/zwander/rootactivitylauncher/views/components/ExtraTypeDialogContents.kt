package tk.zwander.rootactivitylauncher.views.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import tk.zwander.rootactivitylauncher.data.ExtraType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExtrasTypeDialogContents(
    initial: ExtraType,
    onTypeSelected: (ExtraType) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val sortedTypes = remember {
        ExtraType.values().sortedBy {
            context.resources.getString(it.nameRes)
        }
    }

    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items = sortedTypes, key = { it.value }) { type ->
            SelectableCard(
                modifier = Modifier.fillMaxWidth(),
                selected = initial == type,
                onClick = {
                    onTypeSelected(type)
                }
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(min = 56.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = stringResource(id = type.nameRes))
                }
            }
        }
    }
}