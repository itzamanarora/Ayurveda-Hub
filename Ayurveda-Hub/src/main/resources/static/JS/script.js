document.body.style.cursor = 'url("/IMG/vector_Images/cursor.cur"), pointer';

// When the user scrolls the page, execute myFunction
			window.onscroll = function() { myFunction() };

			// Get the navbar
			var navbar = document.getElementById("nav");

			// Get the offset position of the navbar
			var sticky = navbar.offsetTop;

			// Create a placeholder to prevent layout shift (only once, outside of the scroll function)
			var placeholder = document.createElement('div');
			placeholder.style.height = navbar.offsetHeight + 'px';

			// Define the myFunction to toggle sticky class and placeholder
			function myFunction() {
			  if (window.scrollY >= sticky) {
			    navbar.classList.add("sticky");
			    // Insert the placeholder if it doesn't exist next to the navbar
			    if (!navbar.nextSibling || navbar.nextSibling !== placeholder) {
			      navbar.parentNode.insertBefore(placeholder, navbar.nextSibling);
			    }
			  } else {
			    navbar.classList.remove("sticky");
			    // Remove the placeholder if it exists
			    if (navbar.nextSibling === placeholder) {
			      navbar.parentNode.removeChild(placeholder);
			    }
			  }
			}

// -----------------Signup popup-----------------
function opensignup() {
  document.getElementById("signup").style.display = "flex";
}

function closesignup() {
  document.getElementById("signup").style.display = "none";
}

//---------------------LogIn-----------------------
function openlogin() {
  document.getElementById("login").style.display = "flex";
}

function closelogin() {
  document.getElementById("login").style.display = "none";
}

// -----------------Registration popup-----------------
function openRegi() {
  document.getElementById("regi").style.display = "flex";
}

function closeRegi() {
  document.getElementById("regi").style.display = "none";
}
// ------------------Scroll Control----------------- 
function closeScroll() {
  document.body.style.overflow = 'hidden';
}

function openScroll() {
  document.body.style.overflow = 'auto';
}

//---------------- Navbar Thing Start End -------------------------

// Add to Cart Button Animation Start
const cartButtons = document.querySelectorAll('.cart-button');

cartButtons.forEach(button => {
  button.addEventListener('click', cartClick);
});

function cartClick(event) {
  let button = this;

  // Disable the button temporarily to prevent multiple clicks
  button.disabled = true;

  // Get the product ID from the button's data attribute
  let productId = button.getAttribute('data-product_id');
  if (!productId) {
    console.error('Product ID is missing!');
    button.disabled = false;
    return;
  }

  // Send an AJAX request to the server to add the product to the cart
  fetch(`/add/${productId}`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
  })
  .then(response => {
    if (!response.ok) {
      throw new Error('Network response was not ok');
    }
    return response.json();
  })
  .then(data => {
    // Check if cartCount is returned and update it
    if (data.cartCount !== undefined) {
      document.getElementById('cart-count').textContent = data.cartCount;
    } else {
      console.error('Cart count not received from server!');
    }

    // Show "Added" text and reset after a short time
    button.querySelector('.add-to-cart').style.display = 'none';
    button.querySelector('.added').style.display = 'inline-block';

    setTimeout(() => {
      button.querySelector('.add-to-cart').style.display = 'inline-block';
      button.querySelector('.added').style.display = 'none';
    }, 2000); // 2 seconds delay
  })
  .catch(error => {
    console.error('Error:', error);
    alert('There was an issue adding the product to the cart. Please try again.');
  })
  .finally(() => {
    // Re-enable button after the animation delay
    setTimeout(() => {
      button.disabled = false;
    }, 2000); // Same delay as the button text toggle
  });
}


// ------------------------ Add to cart Button Animation END  --------------------------------

// ------------------------ Image Slider Animation Start  --------------------------------

let slideIndex = 0;
showSlides();

function showSlides() {
  let i;
  let slides = document.getElementsByClassName("mySlides");
  let dots = document.getElementsByClassName("dot");
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";  
  }
  slideIndex++;
  if (slideIndex > slides.length) {slideIndex = 1}    
  for (i = 0; i < dots.length; i++) {
    dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " active";
  setTimeout(showSlides, 2000); // Change image every 4s seconds
}

// ------------------------ Image Slider Animation Start  --------------------------------

//---------------------------check is user is logined or not for Add to cart ------------------

function addToCart(product_id) {
    // Server se login status check kare
    fetch(opensignup(), closeScroll())
        .then(response => response.json())
        .then(isLoggedIn => {
            if (isLoggedIn) {
                // Agar login hai, to cart mein add kare
                addProductToCart(product_id);
            } else {
                // Agar login nahi hai, to login page par redirect kare
                window.location.href = '/login_signup';
            }
        })
        .catch(error => console.error('Error checking login status:', error));
}