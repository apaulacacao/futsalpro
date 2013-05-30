/**
 */
package hu.bme.mit.inf.mvsd.domain.generated.futsal.provider;


import hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalFactory;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.FutsalPackage;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Match;

import java.util.Collection;
import java.util.Date;
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
 * This is the item provider adapter for a {@link hu.bme.mit.inf.mvsd.domain.generated.futsal.Match} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MatchItemProvider
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
	public MatchItemProvider(AdapterFactory adapterFactory) {
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

			addDatePropertyDescriptor(object);
			addFirstEventPropertyDescriptor(object);
			addLastEventPropertyDescriptor(object);
			addChanmpionshipPropertyDescriptor(object);
			addRoundPropertyDescriptor(object);
			addSectionPropertyDescriptor(object);
			addAgeGroupPropertyDescriptor(object);
			addCategoryPropertyDescriptor(object);
			addSeasonPropertyDescriptor(object);
			addCodePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Date feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Match_date_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Match_date_feature", "_UI_Match_type"),
				 FutsalPackage.Literals.MATCH__DATE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the First Event feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFirstEventPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Match_firstEvent_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Match_firstEvent_feature", "_UI_Match_type"),
				 FutsalPackage.Literals.MATCH__FIRST_EVENT,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Last Event feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLastEventPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Match_lastEvent_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Match_lastEvent_feature", "_UI_Match_type"),
				 FutsalPackage.Literals.MATCH__LAST_EVENT,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Chanmpionship feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addChanmpionshipPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Match_chanmpionship_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Match_chanmpionship_feature", "_UI_Match_type"),
				 FutsalPackage.Literals.MATCH__CHANMPIONSHIP,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Round feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRoundPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Match_round_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Match_round_feature", "_UI_Match_type"),
				 FutsalPackage.Literals.MATCH__ROUND,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Section feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSectionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Match_section_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Match_section_feature", "_UI_Match_type"),
				 FutsalPackage.Literals.MATCH__SECTION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Age Group feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAgeGroupPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Match_ageGroup_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Match_ageGroup_feature", "_UI_Match_type"),
				 FutsalPackage.Literals.MATCH__AGE_GROUP,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Category feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCategoryPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Match_category_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Match_category_feature", "_UI_Match_type"),
				 FutsalPackage.Literals.MATCH__CATEGORY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Season feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSeasonPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Match_season_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Match_season_feature", "_UI_Match_type"),
				 FutsalPackage.Literals.MATCH__SEASON,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Code feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCodePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Match_code_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Match_code_feature", "_UI_Match_type"),
				 FutsalPackage.Literals.MATCH__CODE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
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
			childrenFeatures.add(FutsalPackage.Literals.MATCH__TEAM1);
			childrenFeatures.add(FutsalPackage.Literals.MATCH__TEAM2);
			childrenFeatures.add(FutsalPackage.Literals.MATCH__REFEREE1);
			childrenFeatures.add(FutsalPackage.Literals.MATCH__REFEREE2);
			childrenFeatures.add(FutsalPackage.Literals.MATCH__REFEREE3);
			childrenFeatures.add(FutsalPackage.Literals.MATCH__SUPERVISOR);
			childrenFeatures.add(FutsalPackage.Literals.MATCH__LOCATION);
			childrenFeatures.add(FutsalPackage.Literals.MATCH__EVENTS);
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
	 * This returns Match.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Match"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		Date labelValue = ((Match)object).getDate();
		String label = labelValue == null ? null : labelValue.toString();
		return label == null || label.length() == 0 ?
			getString("_UI_Match_type") :
			getString("_UI_Match_type") + " " + label;
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

		switch (notification.getFeatureID(Match.class)) {
			case FutsalPackage.MATCH__DATE:
			case FutsalPackage.MATCH__CHANMPIONSHIP:
			case FutsalPackage.MATCH__ROUND:
			case FutsalPackage.MATCH__SECTION:
			case FutsalPackage.MATCH__AGE_GROUP:
			case FutsalPackage.MATCH__CATEGORY:
			case FutsalPackage.MATCH__SEASON:
			case FutsalPackage.MATCH__CODE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case FutsalPackage.MATCH__TEAM1:
			case FutsalPackage.MATCH__TEAM2:
			case FutsalPackage.MATCH__REFEREE1:
			case FutsalPackage.MATCH__REFEREE2:
			case FutsalPackage.MATCH__REFEREE3:
			case FutsalPackage.MATCH__SUPERVISOR:
			case FutsalPackage.MATCH__LOCATION:
			case FutsalPackage.MATCH__EVENTS:
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
				(FutsalPackage.Literals.MATCH__TEAM1,
				 FutsalFactory.eINSTANCE.createTeam()));

		newChildDescriptors.add
			(createChildParameter
				(FutsalPackage.Literals.MATCH__TEAM2,
				 FutsalFactory.eINSTANCE.createTeam()));

		newChildDescriptors.add
			(createChildParameter
				(FutsalPackage.Literals.MATCH__REFEREE1,
				 FutsalFactory.eINSTANCE.createReferee()));

		newChildDescriptors.add
			(createChildParameter
				(FutsalPackage.Literals.MATCH__REFEREE2,
				 FutsalFactory.eINSTANCE.createReferee()));

		newChildDescriptors.add
			(createChildParameter
				(FutsalPackage.Literals.MATCH__REFEREE3,
				 FutsalFactory.eINSTANCE.createReferee()));

		newChildDescriptors.add
			(createChildParameter
				(FutsalPackage.Literals.MATCH__SUPERVISOR,
				 FutsalFactory.eINSTANCE.createSupervisor()));

		newChildDescriptors.add
			(createChildParameter
				(FutsalPackage.Literals.MATCH__LOCATION,
				 FutsalFactory.eINSTANCE.createPitch()));

		newChildDescriptors.add
			(createChildParameter
				(FutsalPackage.Literals.MATCH__EVENTS,
				 FutsalFactory.eINSTANCE.createGoal()));

		newChildDescriptors.add
			(createChildParameter
				(FutsalPackage.Literals.MATCH__EVENTS,
				 FutsalFactory.eINSTANCE.createFault()));

		newChildDescriptors.add
			(createChildParameter
				(FutsalPackage.Literals.MATCH__EVENTS,
				 FutsalFactory.eINSTANCE.createTimeOut()));

		newChildDescriptors.add
			(createChildParameter
				(FutsalPackage.Literals.MATCH__EVENTS,
				 FutsalFactory.eINSTANCE.createSubstitution()));
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
			childFeature == FutsalPackage.Literals.MATCH__TEAM1 ||
			childFeature == FutsalPackage.Literals.MATCH__TEAM2 ||
			childFeature == FutsalPackage.Literals.MATCH__REFEREE1 ||
			childFeature == FutsalPackage.Literals.MATCH__REFEREE2 ||
			childFeature == FutsalPackage.Literals.MATCH__REFEREE3;

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
