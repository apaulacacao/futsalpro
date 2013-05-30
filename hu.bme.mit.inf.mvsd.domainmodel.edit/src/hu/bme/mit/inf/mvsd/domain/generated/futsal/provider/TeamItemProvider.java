/**
 */
package hu.bme.mit.inf.mvsd.domain.generated.futsal.provider;


import hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalFactory;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Team;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Team} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TeamItemProvider
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TeamItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addSubjectPropertyDescriptor(object);
			addCaptainPropertyDescriptor(object);
			addNamePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Subject feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSubjectPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Team_subject_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Team_subject_feature", "_UI_Team_type"),
				 FutsalPackage.Literals.TEAM__SUBJECT,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Captain feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCaptainPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Team_captain_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Team_captain_feature", "_UI_Team_type"),
				 FutsalPackage.Literals.TEAM__CAPTAIN,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Team_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Team_name_feature", "_UI_Team_type"),
				 FutsalPackage.Literals.TEAM__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(FutsalPackage.Literals.TEAM__GOAL_KEEPER);
			childrenFeatures.add(FutsalPackage.Literals.TEAM__FIELD_PLAYERS);
			childrenFeatures.add(FutsalPackage.Literals.TEAM__SUBTITUTE_PLAYERS);
			childrenFeatures.add(FutsalPackage.Literals.TEAM__SUBTITUTE_GOAL_KEEPERS);
			childrenFeatures.add(FutsalPackage.Literals.TEAM__BENCH);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Team.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Team"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Team)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Team_type") :
			getString("_UI_Team_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Team.class)) {
			case FutsalPackage.TEAM__NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case FutsalPackage.TEAM__GOAL_KEEPER:
			case FutsalPackage.TEAM__FIELD_PLAYERS:
			case FutsalPackage.TEAM__SUBTITUTE_PLAYERS:
			case FutsalPackage.TEAM__SUBTITUTE_GOAL_KEEPERS:
			case FutsalPackage.TEAM__BENCH:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(FutsalPackage.Literals.TEAM__GOAL_KEEPER,
				 FutsalFactory.eINSTANCE.createGoalKeeper()));

		newChildDescriptors.add
			(createChildParameter
				(FutsalPackage.Literals.TEAM__FIELD_PLAYERS,
				 FutsalFactory.eINSTANCE.createPlayer()));

		newChildDescriptors.add
			(createChildParameter
				(FutsalPackage.Literals.TEAM__FIELD_PLAYERS,
				 FutsalFactory.eINSTANCE.createGoalKeeper()));

		newChildDescriptors.add
			(createChildParameter
				(FutsalPackage.Literals.TEAM__SUBTITUTE_PLAYERS,
				 FutsalFactory.eINSTANCE.createPlayer()));

		newChildDescriptors.add
			(createChildParameter
				(FutsalPackage.Literals.TEAM__SUBTITUTE_PLAYERS,
				 FutsalFactory.eINSTANCE.createGoalKeeper()));

		newChildDescriptors.add
			(createChildParameter
				(FutsalPackage.Literals.TEAM__SUBTITUTE_GOAL_KEEPERS,
				 FutsalFactory.eINSTANCE.createGoalKeeper()));

		newChildDescriptors.add
			(createChildParameter
				(FutsalPackage.Literals.TEAM__BENCH,
				 FutsalFactory.eINSTANCE.createCrew()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == FutsalPackage.Literals.TEAM__GOAL_KEEPER ||
			childFeature == FutsalPackage.Literals.TEAM__FIELD_PLAYERS ||
			childFeature == FutsalPackage.Literals.TEAM__SUBTITUTE_PLAYERS ||
			childFeature == FutsalPackage.Literals.TEAM__SUBTITUTE_GOAL_KEEPERS;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return FutsalEditPlugin.INSTANCE;
	}

}
