package com.anupcowkur.herebedragons;

import com.intellij.codeInsight.TargetElementUtil;
import com.intellij.codeInsight.daemon.LineMarkerInfo;
import com.intellij.codeInsight.daemon.LineMarkerProvider;
import com.intellij.openapi.util.IconLoader;
import com.intellij.psi.*;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import javax.swing.Icon;

import com.intellij.psi.search.searches.MethodReferencesSearch;
import com.intellij.util.Processor;
import com.intellij.util.Query;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.anupcowkur.herebedragons.AnnotationDetector.hasAnnotation;
import static com.anupcowkur.herebedragons.Constants.CLASS_SIDE_EFFECT;
import static com.intellij.codeHighlighting.Pass.UPDATE_ALL;
import static com.intellij.openapi.editor.markup.GutterIconRenderer.Alignment.LEFT;

public class SideEffectLineMarkerProvider implements LineMarkerProvider {
    private static final Icon ICON = IconLoader.getIcon("/icons/dragon.png");

    /**
     * @return a {@link com.intellij.codeInsight.daemon.GutterIconNavigationHandler} if the element
     * is a PsiMethod annotated with @SideEffect.
     */
    @Nullable
    @Override
    public LineMarkerInfo getLineMarkerInfo(@NotNull final PsiElement element) {
        // Check if expression
        if (element instanceof PsiReferenceExpression) {
            PsiReferenceExpression referenceExpression = (PsiReferenceExpression) element;

            // Check if expression has method
            if (referenceExpression.resolve() instanceof PsiMethod) {
                PsiMethod method = (PsiMethod) referenceExpression.resolve();

                // Does it have a @SideEffect?
                if (hasAnnotation(method, CLASS_SIDE_EFFECT)) {
                    return new LineMarkerInfo<PsiElement>(element, element.getTextRange(), ICON,
                            UPDATE_ALL, null, null, LEFT);
                }
            }
        }

        return null;
    }

    @Override
    public void collectSlowLineMarkers(@NotNull List<PsiElement> psiElements,
                                       @NotNull Collection<LineMarkerInfo> lineMarkerInfos) {

    }
}