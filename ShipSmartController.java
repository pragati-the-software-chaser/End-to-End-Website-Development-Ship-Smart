package edu.msu.shipsmart;

import java.util.ArrayList;
import java.util.Date;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import edu.msu.shipsmart.domain.AdminUserExtn;
import edu.msu.shipsmart.domain.CustomerSignUp;
import edu.msu.shipsmart.domain.FormPromoCode;
import edu.msu.shipsmart.domain.FormShipFrom;
import edu.msu.shipsmart.domain.FormShipTo;
import edu.msu.shipsmart.domain.SignedUser;
import edu.msu.shipsmart.domain.TrackingOrder;
import edu.msu.shipsmart.domain.UserOrder;
import edu.msu.shipsmart.repo.CustomerSignUpRepo;
import edu.msu.shipsmart.repo.FormPromoCodeRepo;
import edu.msu.shipsmart.repo.SignedUserRepo;
import edu.msu.shipsmart.repo.TrackingOrderRepo;
import edu.msu.shipsmart.repo.UserOrderRepo;

@Controller
public class ShipSmartController {

	@Autowired
	private SignedUserRepo signedUserRepo;
	
	@Autowired
	private UserOrderRepo userOrderRepo;
	
	@Autowired
	private FormPromoCodeRepo formPromoCodeRepo;
	
	@Autowired
	private TrackingOrderRepo trackingOrderRepo;
	
	@Autowired
    private JavaMailSender javaMailSender;

	@GetMapping("/home")
	public String home(Model model) {
		// model.addAttribute("name", name);
		
		return "home";
	}

	@GetMapping("/login")
	public String login(Model model) {
		// model.addAttribute("name", name);
		return "login";
	}

	@GetMapping("/signup")
	public String signup(Model model) {
		// model.addAttribute("name", name);
		return "signup";
	}

	@GetMapping("/createShipment2")
	public String createShipment(Model model) {
		// model.addAttribute("name", name);
		
		return "create-shipment3";
	}
	@GetMapping("/createShipment")
	public String createShipment2(@ModelAttribute("userOrder") UserOrder userOrder,BindingResult bindingResult,Model model) {
		// model.addAttribute("name", name);
		 if(bindingResult.hasErrors()){
	            System.out.println("There was a error "+bindingResult);

	            return "home";
	        }
		UserOrder u= new UserOrder();
		model.addAttribute("userOrder", u);
		return "create-shipment";
	}
	@ModelAttribute("countriesList")
	public Map<String,String> countriesList() {
		String[] countryCodes = Locale.getISOCountries();
		Map<String, String> counties = new HashMap<String, String>();
		for (String countryCode : countryCodes) {

			Locale locale = new Locale("", countryCode);
			// String iso = locale.getISO3Country();
			// String code = locale.getCountry();
			String name = locale.getDisplayCountry();
			counties.put(countryCode, name);
			// System.out.println("countryCode:"+countryCode+",name:"+name+",ios:"+iso);
		}
		return counties;
	}
	@ModelAttribute("promoCodes")
	public List<FormPromoCode> promoCodes() {
		Iterable<FormPromoCode> promoIterble=formPromoCodeRepo.findAll();
		List<FormPromoCode> result = new ArrayList<FormPromoCode>();
		promoIterble.forEach(result::add);
		return result;
	}
	
	//@GetMapping("/getTracking")
	//@PostMapping("/getTracking")
	@RequestMapping(value = "/getTracking", method = { RequestMethod.POST, RequestMethod.GET })

	public String getTracking(@RequestParam(value = "trackingId", required = false) String trackingId,
			Model model) {
		// model.addAttribute("name", name);
		List<TrackingOrder> trackingOrders=trackingOrderRepo.findTrackingOrderByTracking(trackingId);
		model.addAttribute("tracking", trackingOrders);
		return "order-tracking";
	}

	@GetMapping("/orderAdmin")
	public String dashboard(@RequestParam(value = "orderId", required = false) Long orderId,
			Model model) {
		// model.addAttribute("name", name);
		setDashBoardModel(orderId,model);
	
		return "order-admin";
	}
	@GetMapping("/dashboard")
	public String admin(Model model) {
		
		Iterable<UserOrder> optOrder=userOrderRepo.findAll();
		List<UserOrder> result = new ArrayList<>();
		optOrder.forEach(result::add);
		model.addAttribute("userOrders", result);
		return "dashboard";
	}
	
	
	private void setDashBoardModel(long orderId,Model model) {
		UserOrder userOrder=null;
		Optional<UserOrder> optOrder = userOrderRepo.findById(orderId);
		if (optOrder.isPresent())
			userOrder = optOrder.get();
		model.addAttribute("userOrder", userOrder);
		
		model.addAttribute("trackingOrder", new TrackingOrder());
		List<TrackingOrder> trackingOrders=trackingOrderRepo.findTrackingOrderByOrderId(orderId);
		model.addAttribute("trackingOrders", trackingOrders);
	}
	@PostMapping("/updateTracking")
	public String addTracking(@ModelAttribute TrackingOrder trackingOrder, Model model) {
		if("delete".equals(trackingOrder.getAction())) {
			
			trackingOrderRepo.delete(trackingOrder);
			
		}else {
			trackingOrderRepo.save(trackingOrder);
		}
		
		setDashBoardModel(trackingOrder.getOrderId(),model);
		return "order-admin";
		
	}

	@PostMapping("/customerSignup")
	public String customerSignup(@ModelAttribute CustomerSignUp customerSignUp, Model model) {
		System.out.print(customerSignUp);
		// customerSignUpRepo.save(customerSignUp);

		// model.addAttribute("name", name);
		return "login";
	}

	@PostMapping("/createUser")
	public String signUp(@ModelAttribute SignedUser signedUser, Model model) {
		System.out.print(signedUser);

		if (signedUser.getEmployeeId() != null) {
			AdminUserExtn admn = new AdminUserExtn();
			admn.setEmployeeId(signedUser.getEmployeeId());
			admn.setSignedUser(signedUser);
			signedUser.setAdmin(admn);
		}
		try {
			SignedUser dbUser = signedUserRepo.findSignedUserByEmail(signedUser.getEmail());
			if (dbUser != null) {
				model.addAttribute("error", "User already exist with the same email id");
				return "signup";
			} else {
				signedUserRepo.save(signedUser);
				model.addAttribute("message", "User created successfully.");
			}

		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			System.out.println("Exception" + e);
		}

		// model.addAttribute("name", name);
		return "login";
	}

	@GetMapping("/aboutUs")
	public String aboutUs(Model model) {
		// model.addAttribute("name", name);
		return "aboutUs";
	}

	@GetMapping("/contactUs")
	public String contactUs(Model model) {
		// model.addAttribute("name", name);
		return "contactUs";
	}
	@PostMapping("/submitShipment")
	public String submitShipment( @ModelAttribute UserOrder userOrder,BindingResult bindingResult, Model model,HttpServletRequest request) {
		
		
		HttpSession session = request.getSession();
		SignedUser user = (SignedUser) session.getAttribute("user");
		if(user==null) return "login";
		
		userOrder.setUserId(user.getUserId());
		
		if(userOrder !=null && userOrder.getFormCheckout() !=null) {
		    userOrder.getFormShipFrom().setUserOrder(userOrder);
		    userOrder.getFormShipTo().setUserOrder(userOrder);
		    userOrder.getFormPackage().setUserOrder(userOrder);
		    userOrder.getFormSchedulePickup().setUserOrder(userOrder);
		    userOrder.getFormCheckout().setDeliveryDate(new Date());
		    userOrder.getFormCheckout().setUserOrder(userOrder);
		    userOrder.setCreatedDate(new Date());
		    UUID uuid = UUID.randomUUID();
		    userOrder.setTracking(uuid.toString());
		    if(userOrder.getFormSchedulePickup() !=null &&
		    		(userOrder.getFormSchedulePickup().getPickupTime()==null|| userOrder.getFormSchedulePickup().getPickupDate()==null)) {
		    	userOrder.setFormSchedulePickup(null);
		    }
			userOrderRepo.save(userOrder);
		}
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(userOrder.getCreatedDate());
		model.addAttribute("tracking", userOrder.getTracking());
		model.addAttribute("userName", user.getFirstName());
		model.addAttribute("creationDate", date);
		try {
			String subject="Order Confirmation";
			String message=" We have received your order, Order details below\n Tracking Id:"+userOrder.getTracking()+"\nOrder Creation Date:"+date+"\nPlease keep tracking number for your reference.";
			sendEmail(user.getEmail(), subject, message);
		}catch(Exception ee) {
			ee.printStackTrace();
		}
		return "order-confirmation";
		//return "create-shipment";
	}
	@PostMapping("/login")
	public String login( @ModelAttribute SignedUser signedUser, Model model, HttpServletRequest request) {
		
		try {
			SignedUser dbUser = signedUserRepo.findSignedUserByEmail(signedUser.getEmail());
			if (dbUser == null) {
				model.addAttribute("error", "No user found");
				return "login";
			} else if(!dbUser.getPassword().equals(signedUser.getPassword())) {
				model.addAttribute("error", "Invalid user id/password");
				return "login";
			}
			SignedUser user= new SignedUser();
			user.setUserId(dbUser.getUserId());
			user.setFirstName(dbUser.getFirstName());
			user.setLastName(dbUser.getLastName());
			user.setEmail(dbUser.getEmail());
			user.setIs_admin(dbUser.getIs_admin());
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			if("Y".equals(user.getIs_admin())) {
				Iterable<UserOrder> optOrder=userOrderRepo.findAll();
				List<UserOrder> result = new ArrayList<>();
				optOrder.forEach(result::add);
				model.addAttribute("userOrders", result);
				return "dashboard";
			}

		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			System.out.println("Exception" + e);
		}
		return "home";
	}
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		// model.addAttribute("name", name);
		HttpSession session = request.getSession();
		session.invalidate();
		return "home";
	}
	@GetMapping("/order-confirmation")
	public String orderConfirmation(Model model) {
		// model.addAttribute("name", name);
	
		return "order-confirmation";
	}
	@GetMapping("/getFreeQuote")
	public String getFreeQuote(Model model) {
		// model.addAttribute("name", name);
		
		return "free-quote";
	}
	@GetMapping("/deliveryRates")
	public String deliveryRates(Model model) {
		// model.addAttribute("name", name);
		
		return "deliveryrates";
	}
	@GetMapping("/myProfile")
	public String myProfile(Model model, HttpServletRequest request) {
		// model.addAttribute("name", name);
		HttpSession session = request.getSession();
		SignedUser user = (SignedUser) session.getAttribute("user");
		if(user==null) return "login";
		Optional<SignedUser> optUser=signedUserRepo.findById(user.getUserId());
		if(optUser.isPresent())
			model.addAttribute("userProfile",optUser.get());
		
		List<UserOrder> userOrders=userOrderRepo.findUserOrderByUserId(user.getUserId());
		model.addAttribute("userOrders",userOrders);
		return "my-profile";
	}
	@PostMapping("/sendMessage")
	public String sendMessage(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "phoneNumber", required = false) String phoneNumber,
			@RequestParam(value = "businessName", required = false) String businessName,
			@RequestParam(value = "message", required = false) String message,
			Model model) {
		    String subject="Request for free quote";
		    String emailbody="Contacts:\n"+"Name:"+name+"\nEmail:"+email+"\nPhone Number:"+phoneNumber+"\nBusiness Name:"+businessName+"\nMessage:"+message;
		    
		    sendEmail("representativepatco@gmail.com", subject, emailbody);
		    model.addAttribute("message", "Your message has been sent successfully, our representative will contact you soon ! Thank you");
		return "free-quote";
	}
	@GetMapping("/international_shipping")
	public String international_shipping(Model model) {
		// model.addAttribute("name", name);
		
		return "international_shipping";
	}
	
	
	  void sendEmail(String toAddress,String subject,String message) {

	        SimpleMailMessage msg = new SimpleMailMessage();
	      //  msg.setTo("sujith.tk@gmail.com", "athikkals1@montclair.edu");
	        msg.setTo(toAddress);

	        msg.setSubject(subject);
	        msg.setText(message);

	        javaMailSender.send(msg);

	    }

}
