import React from 'react'
import './Footer.css'

const Footer = () => {

  return (
    <div className="footer-container">
			<div className="footer">
				<div className="fLists">
					<ul className="fList">
						<li className="fListHeaderItems">TIKI FAKE</li>
						<li className="fListItems">Introduction</li>
						<li className="fListItems">Online</li>
						<li className="fListItems">Vochers</li>
						<li className="fListItems">Liên Hệ Bán Hàng</li>
					</ul>

					<ul className="fList">
						<li className="fListHeaderItems">Constraint</li>
						<li className="fListItems">General Terms</li>
						<li className="fListItems">Transaction Terms</li>
						<li className="fListItems">Payment policy</li>
						<li className="fListItems">Privacy Policy</li>
					</ul>

					<ul className="fList">
						<li className="fListHeaderItems">
							Contact{" "}
						</li>
						<li className="fListItems">Facebook</li>
						<li className="fListItems">Instagram</li>
						<li className="fListItems">Mail</li>
						<li className="fListItems">Twitter</li>
					</ul>

					<ul className="fList">
						<li className="fListHeaderItems">
            Customer care
						</li>

						<li className="fListItems">Hotline: 1900 6017</li>
						<li className="fListItems">
							Time: 8:00 - 22:00 
						</li>
						<li className="fListItems">
							Email support: hoidap@tiki.vn
						</li>
					</ul>
				</div>
			</div>
		</div>
  )
}

export default Footer
